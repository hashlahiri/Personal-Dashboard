import { fetchStocks } from "@/lib/api";
import { StatCards } from "@/components/sections/StatCards";
import { PortfolioPerformance } from "@/components/sections/PortfolioPerformance";
import { DividendWidget } from "@/components/sections/DividendWidget";
import { Watchlist } from "@/components/sections/Watchlist";
import { TrendingStocks } from "@/components/sections/TrendingStocks";
import { LatestTransactions } from "@/components/sections/LatestTransactions";

export default async function DashboardPage() {
  return (
    <div className="space-y-4">
      <h1 className="text-2xl font-semibold">Dashboard</h1>
      <p className="text-sm text-zinc-600 dark:text-zinc-400">A placeholder page for Dashboard-related views. Replace this Dashboard UI.</p>
    </div>
  );
}

