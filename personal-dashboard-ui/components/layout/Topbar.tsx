"use client";

import { Eclipse, LucideChartBar } from "lucide-react";
import { useState } from "react";

export function Topbar() {
  const [query, setQuery] = useState("");
  return (
    <header className="sticky top-0 z-40 flex items-center justify-between gap-4 border-b border-zinc-200/60 bg-white/70 px-4 py-3 backdrop-blur dark:border-zinc-800/60 dark:bg-zinc-900/40">
      <div className="flex items-center gap-3">
        <button className="btn btn-ghost rounded-full p-2" aria-label="Sidebar toggle">
          <LucideChartBar className="h-5 w-5" />
        </button>
        <button className="btn btn-ghost rounded-full p-2" aria-label="Mode toggle">
          <Eclipse className="h-5 w-5" />
        </button>
      </div>
    </header>
  );
}
