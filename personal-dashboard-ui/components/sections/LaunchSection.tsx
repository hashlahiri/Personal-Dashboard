"use client";

import { useEffect, useState } from "react";
import { motion } from "framer-motion";
import { Rocket } from "lucide-react";

type Launch = {
  name: string;
  date_unix: number;
  patch: { small: string } | null;
};

async function getNextLaunch(): Promise<Launch> {
  const res = await fetch("https://api.spacexdata.com/v5/launches/next");
  if (!res.ok) throw new Error("Launch fetch failed");
  return res.json();
}

export function LaunchSection() {
  const [launch, setLaunch] = useState<Launch | null>(null);
  const [left, setLeft] = useState<number>(0);

  useEffect(() => {
    getNextLaunch()
      .then((l) => {
        setLaunch(l);
        setLeft(Math.max(0, l.date_unix * 1000 - Date.now()));
      })
      .catch(() => setLaunch(null));
  }, []);

  useEffect(() => {
    if (!launch) return;
    const id = setInterval(() => setLeft(Math.max(0, launch.date_unix * 1000 - Date.now())), 1000);
    return () => clearInterval(id);
  }, [launch]);

  if (!launch)
    return (
      <div className="rounded-xl border border-zinc-200/60 bg-white/60 p-4 backdrop-blur dark:border-zinc-800/60 dark:bg-zinc-900/40">
        <p className="text-sm text-zinc-600">No upcoming launch</p>
      </div>
    );

  const days = Math.floor(left / 86400000);
  const hrs = Math.floor((left % 86400000) / 3600000);
  const mins = Math.floor((left % 3600000) / 60000);
  const secs = Math.floor((left % 60000) / 1000);

  return (
    <motion.div
      initial={{ opacity: 0, y: 20 }}
      animate={{ opacity: 1, y: 0 }}
      className="rounded-xl border border-zinc-200/60 bg-white/60 p-4 backdrop-blur dark:border-zinc-800/60 dark:bg-zinc-900/40"
    >
      <div className="flex items-center gap-2 mb-2">
        <Rocket className="h-4 w-4 text-zinc-500" />
        <p className="text-sm text-zinc-600 dark:text-zinc-400">Next SpaceX</p>
      </div>
      <p className="text-lg font-semibold">{launch.name}</p>
      <div className="mt-2 grid grid-cols-4 gap-2 text-center">
        <div>
          <p className="text-xl font-bold">{days}</p>
          <p className="text-xs text-zinc-500">d</p>
        </div>
        <div>
          <p className="text-xl font-bold">{hrs}</p>
          <p className="text-xs text-zinc-500">h</p>
        </div>
        <div>
          <p className="text-xl font-bold">{mins}</p>
          <p className="text-xs text-zinc-500">m</p>
        </div>
        <div>
          <p className="text-xl font-bold">{secs}</p>
          <p className="text-xs text-zinc-500">s</p>
        </div>
      </div>
      {launch.patch && (
        <img src={launch.patch.small} alt="Patch" className="mt-3 h-12 w-12 mx-auto" />
      )}
    </motion.div>
  );
}