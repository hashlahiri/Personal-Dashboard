"use client";

import { useEffect, useState } from "react";
import { motion } from "framer-motion";
import { Smile } from "lucide-react";

type Comic = {
  month: string;
  num: number;
  link: string;
  year: string;
  news: string;
  safe_title: string;
  transcript: string;
  alt: string;
  img: string;
  title: string;
  day: string;
};

async function getTodayComic(): Promise<Comic> {
  // 1. add no-cors proxy (for dev only) or use a CORS-proxy service
  // 2. force https on image later
  const res = await fetch("/api/xkcd");
  if (!res.ok) throw new Error("XKCD fetch failed");
  return res.json();
}

export function XkcdSection() {
  const [comic, setComic] = useState<Comic | null>(null);

  useEffect(() => {
    getTodayComic()
      .then((c) => setComic({ ...c, img: c.img.replace("http://", "https://") })) // 3. fix mixed-content
      .catch(() => setComic(null));
  }, []);

  if (!comic)
    return (
      <div className="rounded-xl border border-zinc-200/60 bg-white/60 p-4 backdrop-blur dark:border-zinc-800/60 dark:bg-zinc-900/40">
        <p className="text-sm text-zinc-600">Comic unavailable (CORS or network)</p>
      </div>
    );

  return (
    <motion.div
      initial={{ opacity: 0, y: 20 }}
      animate={{ opacity: 1, y: 0 }}
      className="rounded-xl border border-zinc-200/60 bg-white/60 p-4 backdrop-blur dark:border-zinc-800/60 dark:bg-zinc-900/40"
    >
      <div className="flex items-center gap-2 mb-2">
        <Smile className="h-4 w-4 text-zinc-500" />
        <p className="text-sm text-zinc-600 dark:text-zinc-400">Today’s XKCD</p>
      </div>
      <p className="text-sm font-medium mb-2">{comic.safe_title}</p>
      <img
        src={comic.img}
        alt={comic.alt}
        className="rounded-lg border border-zinc-200 dark:border-zinc-700 w-full"
      />
      <p className="text-xs text-zinc-500 dark:text-zinc-400 mt-2">{comic.alt}</p>
    </motion.div>
  );
}