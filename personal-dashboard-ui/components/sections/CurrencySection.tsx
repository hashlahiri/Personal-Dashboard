"use client";

import { useEffect, useState } from "react";
import { motion } from "framer-motion";
import { ArrowRightLeft } from "lucide-react";
import axios from "axios";

/* ---------- types ---------- */
type FrankResponse = {
  amount: number;
  base: string;
  date: string;
  rates: Record<string, number>;
};

/* ---------- (tiny)-ing cache: limited options for now ---------- */
const CACHE_KEY = "fx_cache";
const CACHE_TTL = 1000 * 60 * 60 * 24; // 24 h

const SYMBOLS = ["USD", "EUR", "GBP", "JPY", "CAD", "AUD", "CHF", "CNY", "INR"];

export function CurrencySection() {
  const [amount, setAmount] = useState<string>("100");
  const [from, setFrom] = useState<string>("USD");
  const [to, setTo] = useState<string>("EUR");
  const [rate, setRate] = useState<number>(0);
  const [result, setResult] = useState<string>("");
  const [loading, setLoading] = useState<boolean>(false);
  const [error, setError] = useState<string>("");

  /* ---------- fetch rates + cache ---------- */
useEffect(() => {
  async function getRates() {
    setLoading(true); setError("");

    // 1. check cache
    const cached = localStorage.getItem(CACHE_KEY);
    if (cached) {
      const { ts, data } = JSON.parse(cached) as { ts: number; data: FrankResponse };
      if (Date.now() - ts < CACHE_TTL && data.rates[to]) {
        setRate(data.rates[to]); // ← direct read
        setLoading(false);
        return;
      }
    }

    // 2. fetch from Frankfurter
    try {
      const { data } = await axios.get<FrankResponse>(
        "https://api.frankfurter.app/latest",
        { params: { from, symbols: SYMBOLS.join(",") } }
      );
      localStorage.setItem(CACHE_KEY, JSON.stringify({ ts: Date.now(), data }));
      setRate(data.rates[to]); // ← direct read
    } catch {
      setError("Rate unavailable");
      setRate(0);
    } finally {
      setLoading(false);
    }
  }
  getRates();
}, [from, to]);

  /* ---------- auto-calcs ---------- */
  useEffect(() => {
    const n = Number(amount);
    if (!Number.isFinite(n) || !rate) {
      setResult("");
      return;
    }
    setResult((n * rate).toFixed(2));
  }, [amount, rate]);

  /* ---------- swapping ---------- */
  const swap = () => {
    setFrom(to);
    setTo(from);
  };

  return (
    <motion.div
      initial={{ opacity: 0, y: 20 }}
      animate={{ opacity: 1, y: 0 }}
      className="rounded-xl border border-zinc-200/60 bg-white/60 p-6 backdrop-blur dark:border-zinc-800/60 dark:bg-zinc-900/40"
    >
      <h3 className="text-lg font-semibold mb-4">Currency Converter</h3>

      <div className="space-y-4">
        {/* amount below*/}
        <div>
          <label className="mb-1 block text-sm text-zinc-600 dark:text-zinc-400">Amount</label>
          <input
            type="number"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
            className="w-full rounded-lg border border-zinc-300 bg-zinc-50 p-3 text-sm dark:border-zinc-700 dark:bg-zinc-800"
            placeholder="100"
          />
        </div>

        {/* currency row with swap */}
        <div className="flex items-end gap-3">
          <div className="flex-1">
            <label className="mb-1 block text-sm text-zinc-600 dark:text-zinc-400">From</label>
            <select
              value={from}
              onChange={(e) => setFrom(e.target.value)}
              className="w-full rounded-lg border border-zinc-300 bg-zinc-50 p-3 text-sm dark:border-zinc-700 dark:bg-zinc-800"
            >
              {SYMBOLS.map((c) => (
                <option key={c} value={c}>{c}</option>
              ))}
            </select>
          </div>

          <motion.button
            onClick={swap}
            whileTap={{ rotate: 180 }}
            className="rounded-full p-2 hover:bg-zinc-200 dark:hover:bg-zinc-700"
            aria-label="swap currencies"
          >
            <ArrowRightLeft className="h-5 w-5" />
          </motion.button>

          <div className="flex-1">
            <label className="mb-1 block text-sm text-zinc-600 dark:text-zinc-400">To</label>
            <select
              value={to}
              onChange={(e) => setTo(e.target.value)}
              className="w-full rounded-lg border border-zinc-300 bg-zinc-50 p-3 text-sm dark:border-zinc-700 dark:bg-zinc-800"
            >
              {SYMBOLS.map((c) => (
                <option key={c} value={c}>{c}</option>
              ))}
            </select>
          </div>
        </div>

        {/* result + rate calcs */}
        {error ? (
          <p className="text-sm text-rose-600 dark:text-rose-400">{error}</p>
        ) : (
          <div className="rounded-lg bg-zinc-100 p-4 text-center dark:bg-zinc-800">
            <p className="text-sm text-zinc-600 dark:text-zinc-400">Converted amount</p>
            <p className="text-xl font-semibold">
              {loading ? "⋯" : `${result} ${to}`}
            </p>
            <p className="text-xs text-zinc-500 dark:text-zinc-400 mt-1">
              1 {from} = {rate.toFixed(4)} {to}
            </p>
          </div>
        )}
      </div>
    </motion.div>
  );
}