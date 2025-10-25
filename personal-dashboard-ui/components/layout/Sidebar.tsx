"use client";

import Link from "next/link";
import { usePathname } from "next/navigation";
import { cn } from "@/lib/utils";
import { ChartCandlestick, House, ShoppingCart, BarChart3, Rocket, LayoutDashboard } from "lucide-react";

const nav = [
  { href: "/", label: "Dashboard", icon: House },
  { href: "/stocks", label: "Stocks", icon: ChartCandlestick },
  { href: "/ecommerce", label: "Ecommerce", icon: ShoppingCart },
  { href: "/analytics", label: "Analytics", icon: BarChart3 },
  { href: "/labs", label: "Labs", icon: Rocket },
];

export function Sidebar() {
  const pathname = usePathname();
  return (
    <aside className="hidden border-r border-zinc-200/60 bg-white/60 backdrop-blur dark:border-zinc-800/60 dark:bg-zinc-900/40 md:block">
      <div className="flex items-center gap-2 px-4 py-4">
        <LayoutDashboard className="h-6 w-6" />
        <span className="font-semibold"><a href="/">My Dashboard</a></span>
      </div>
      <nav className="space-y-1 p-2">
        {nav.map((item) => {
          const Icon = item.icon;
          const active = pathname === item.href;
          return (
            <Link
              key={item.href}
              href={item.href as any}
              className={cn(
                "flex items-center gap-3 rounded-xl px-3 py-2 text-sm hover:bg-zinc-100 dark:hover:bg-zinc-800",
                active && "bg-zinc-100 dark:bg-zinc-800 font-medium"
              )}
            >
              <Icon className="h-4 w-4" />
              {item.label}
            </Link>
          );
        })}
      </nav>
    </aside>
  );
}
