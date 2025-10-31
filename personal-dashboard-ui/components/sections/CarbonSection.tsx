"use client";

import { useEffect, useState } from "react";
import { motion } from "framer-motion";
import { Leaf } from "lucide-react";

type Carbon = {
  actual: number;
  index: "very low" | "low" | "moderate" | "high" | "very high";
};

async function getCarbon(): Promise<Carbon> {
  const res = await fetch("https://api.carbonintensity.org.uk/intensity");
  if (!res.ok) throw new Error("Carbon fetch failed");
  const json = await res.json();
  return json.data[0].intensity;
}

const indexColour: Record<Carbon["index"], string> = {
  "very low": "bg-emerald-100 text-emerald-700",
  low: "bg-yellow-100 text-yellow-700",
  moderate: "bg-orange-100 text-orange-700",
  high: "bg-rose-100 text-rose-700",
  "very high": "bg-red-100 text-red-700",
};

export function CarbonSection() {
  const [carbon, setCarbon] = useState<Carbon | null>(null);

  useEffect(() => {
    getCarbon().then(setCarbon).catch(() => setCarbon(null));
  }, []);

  if (!carbon)
    return (
      <div className="rounded-xl border border-zinc-200/60 bg-white/60 p-4 backdrop-blur dark:border-zinc-800/60 dark:bg-zinc-900/40">
        <p className="text-sm text-zinc-600">Carbon data unavailable</p>
      </div>
    );

  return (
    <motion.div
      initial={{ opacity: 0, y: 20 }}
      animate={{ opacity: 1, y: 0 }}
      className="rounded-xl border border-zinc-200/60 bg-white/60 p-4 backdrop-blur dark:border-zinc-800/60 dark:bg-zinc-900/40"
    >
      <div className="flex items-center gap-2 mb-2">
        <Leaf className="h-4 w-4 text-zinc-500" />
        <p className="text-sm text-zinc-600 dark:text-zinc-400">UK Carbon Intensity</p>
      </div>
      <p className="text-lg font-semibold">{carbon.actual} gCO₂/kWh</p>
      <span
        className={`mt-2 inline-block rounded px-2 py-1 text-xs ${indexColour[carbon.index]}`}
      >
        {carbon.index}
      </span>
    </motion.div>
  );
}