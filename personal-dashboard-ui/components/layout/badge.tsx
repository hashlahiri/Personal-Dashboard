import { cn } from "@/lib/utils";

export function Badge({
  children,
  color = "green",
  className
}: { children: React.ReactNode; color?: "green" | "red" | "zinc"; className?: string }) {
  const base =
    color === "green"
      ? "bg-emerald-50 text-emerald-700 dark:bg-emerald-900/30 dark:text-emerald-300"
      : color === "red"
      ? "bg-rose-50 text-rose-700 dark:bg-rose-900/30 dark:text-rose-300"
      : "bg-zinc-100 text-zinc-700 dark:bg-zinc-800 dark:text-zinc-300";
  return (
    <span className={cn("inline-flex items-center gap-1 rounded-full px-2 py-0.5 text-[10px] font-medium", base, className)}>
      {children}
    </span>
  );
}
