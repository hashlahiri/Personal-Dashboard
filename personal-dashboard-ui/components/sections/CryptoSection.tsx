"use client";

import { useEffect, useState } from "react";
import { motion } from "framer-motion";
import { TrendingUp, TrendingDown } from "lucide-react";

type Ticker = {
  symbol: string;
  lastPrice: string;
  priceChangePercent: string;
};

async function getTicker(symbol = "BTCUSDT"): Promise<Ticker> {
  const res = await fetch(`https://api.binance.com/api/v3/ticker/24hr?symbol=${symbol}`);
  if (!res.ok) throw new Error("Ticker fetch failed");
  return res.json();
}

export function CryptoSection({ symbol = "BTCUSDT" }: { symbol?: string }) {
  const [tick, setTick] = useState<Ticker | null>(null);

  useEffect(() => {
    getTicker(symbol).then(setTick).catch(() => setTick(null));
  }, [symbol]);

  if (!tick)
    return (
      <div className="rounded-xl border border-zinc-200/60 bg-white/60 p-4 backdrop-blur dark:border-zinc-800/60 dark:bg-zinc-900/40">
        <p className="text-sm text-zinc-600">Ticker unavailable</p>
      </div>
    );

  const change = Number(tick.priceChangePercent);
  const isUp = change > 0;

  return (
    <motion.div
      initial={{ opacity: 0, y: 20 }}
      animate={{ opacity: 1, y: 0 }}
      className="rounded-xl border border-zinc-200/60 bg-white/60 p-4 backdrop-blur dark:border-zinc-800/60 dark:bg-zinc-900/40"
    >
      <div className="flex items-center justify-between">
        <div>
          <p className="text-sm text-zinc-600 dark:text-zinc-400">24 h change</p>
          <p className={`text-lg font-semibold flex items-center gap-1 ${isUp ? "text-emerald-600" : "text-rose-600"}`}>
            {isUp ? <TrendingUp className="h-4 w-4" /> : <TrendingDown className="h-4 w-4" />}
            {change.toFixed(2)} %
          </p>
        </div>
        <div className="text-right">
          <p className="text-sm text-zinc-600 dark:text-zinc-400">Last price</p>
          <p className="text-lg font-semibold">$ {Number(tick.lastPrice).toLocaleString()}</p>
        </div>
      </div>
      <p className="text-xs text-zinc-500 dark:text-zinc-400 mt-2">{tick.symbol}</p>
    </motion.div>
  );
}