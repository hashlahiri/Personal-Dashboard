"use client";

import { useState } from "react";
import { motion } from "framer-motion";
import { CheckCircle, XCircle } from "lucide-react";
import { checkJsonKeyExists } from "@/services/jsonCompareService";

export function JsonKeySection() {
  const [payload, setPayload]   = useState('{"parent":{"child":"value"}}');
  const [parent, setParent]     = useState("parent");
  const [child, setChild]       = useState("child");
  const [result, setResult]     = useState<boolean | null>(null);
  const [loading, setLoading]   = useState(false);
  const [error, setError]       = useState<string | null>(null);

  const runCheck = async () => {
    setLoading(true);
    setError(null);
    setResult(null);
    try {
      const exists = await checkJsonKeyExists(payload, parent, child);
      setResult(exists);
    } catch (e: any) {
      setError(e?.message ?? "Network error");
    } finally {
      setLoading(false);
    }
  };

  return (
    <motion.div
      initial={{ opacity: 0, y: 20 }}
      animate={{ opacity: 1, y: 0 }}
      className="rounded-xl border border-zinc-200/60 bg-white/60 p-6 backdrop-blur dark:border-zinc-800/60 dark:bg-zinc-900/40"
    >
      <h3 className="mb-4 text-lg font-semibold">JSON Key Exists?</h3>

      <div className="space-y-4">
        {/* Payload textarea */}
        <div>
          <label className="mb-1 block text-sm text-zinc-600 dark:text-zinc-400">Payload (JSON)</label>
          <textarea
            className="w-full rounded-lg border border-zinc-300 bg-zinc-50 p-3 text-sm dark:border-zinc-700 dark:bg-zinc-800"
            rows={4}
            value={payload}
            onChange={(e) => { setPayload(e.target.value); setResult(null); }}
          />
        </div>

        <div className="grid grid-cols-2 gap-4">
          {/* Parent key */}
          <div>
            <label className="mb-1 block text-sm text-zinc-600 dark:text-zinc-400">Parent Key</label>
            <input
              type="text"
              className="w-full rounded-lg border border-zinc-300 bg-zinc-50 p-3 text-sm dark:border-zinc-700 dark:bg-zinc-800"
              value={parent}
              onChange={(e) => { setParent(e.target.value); setResult(null); }}
            />
          </div>

          {/* Child key */}
          <div>
            <label className="mb-1 block text-sm text-zinc-600 dark:text-zinc-400">Child Key</label>
            <input
              type="text"
              className="w-full rounded-lg border border-zinc-300 bg-zinc-50 p-3 text-sm dark:border-zinc-700 dark:bg-zinc-800"
              value={child}
              onChange={(e) => { setChild(e.target.value); setResult(null); }}
            />
          </div>
        </div>

        {/* Action row */}
        <div className="flex items-center justify-between">
          <button
            onClick={runCheck}
            disabled={loading}
            className="rounded-lg bg-blue-600 px-4 py-2 text-sm font-medium text-white transition hover:bg-blue-700 disabled:opacity-60 dark:bg-blue-500 dark:hover:bg-blue-600"
          >
            {loading ? "Checking…" : "Check"}
          </button>

          {/* Result badge */}
          {result !== null && (
            <motion.div
              initial={{ scale: 0.8, opacity: 0 }}
              animate={{ scale: 1, opacity: 1 }}
              className={`flex items-center gap-2 rounded-full px-3 py-1 text-sm font-medium ${result ? "bg-emerald-100 text-emerald-700 dark:bg-emerald-900/30 dark:text-emerald-400" : "bg-rose-100 text-rose-700 dark:bg-rose-900/30 dark:text-rose-400"}`}
            >
              {result ? <CheckCircle className="h-4 w-4" /> : <XCircle className="h-4 w-4" />}
              {result ? "Key exists" : "Key missing"}
            </motion.div>
          )}

          {error && (
            <span className="text-sm text-rose-600 dark:text-rose-400">{error}</span>
          )}
        </div>
      </div>
    </motion.div>
  );
}