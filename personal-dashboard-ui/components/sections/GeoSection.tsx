"use client";

import { useEffect, useState } from "react";
import { motion } from "framer-motion";
import { MapPin } from "lucide-react";

type Geo = {
  ip: string;
  city: string;
  country_name: string;
  country_code: string;
  org: string;
};

async function getGeo(): Promise<Geo> {
  const res = await fetch("/api/geo", { cache: "no-store" });
  if (!res.ok) throw new Error("Geo failed");
  return res.json();
}

export function GeoSection() {
  const [geo, setGeo] = useState<Geo | null>(null);
  const [err, setErr] = useState(false);

  useEffect(() => {
    getGeo()
      .then(setGeo)
      .catch(() => setErr(true));
  }, []);

  if (err)
    return (
      <div className="rounded-xl border border-zinc-200/60 bg-white/60 p-4 backdrop-blur dark:border-zinc-800/60 dark:bg-zinc-900/40">
        <p className="text-sm text-rose-600">Location unavailable</p>
      </div>
    );

  if (!geo) return <GeoSkeleton />;

  return (
    <motion.div
      initial={{ opacity: 0, y: 20 }}
      animate={{ opacity: 1, y: 0 }}
      className="rounded-xl border border-zinc-200/60 bg-white/60 p-4 backdrop-blur dark:border-zinc-800/60 dark:bg-zinc-900/40"
    >
      <div className="flex items-center gap-2 mb-2">
        <MapPin className="h-4 w-4 text-zinc-500" />
        <p className="text-sm text-zinc-600 dark:text-zinc-400">You’re in</p>
      </div>
      <p className="text-lg font-semibold">
        {geo.city}, {geo.country_name} {geo.country_code}
      </p>
      <p className="text-xs text-zinc-500 dark:text-zinc-400 mt-1">{geo.org}</p>
    </motion.div>
  );
}

function GeoSkeleton() {
  return (
    <div className="rounded-xl border border-zinc-200/60 bg-white/60 p-4 backdrop-blur dark:border-zinc-800/60 dark:bg-zinc-900/40">
      <div className="h-4 w-24 rounded bg-zinc-200 dark:bg-zinc-700 animate-pulse" />
      <div className="mt-2 h-5 w-40 rounded bg-zinc-200 dark:bg-zinc-700 animate-pulse" />
    </div>
  );
}