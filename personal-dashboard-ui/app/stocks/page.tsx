import { fetchStocks } from "@/lib/api";
import { StatCards } from "@/components/sections/StatCards";
import { PortfolioPerformance } from "@/components/sections/PortfolioPerformance";
import { DividendWidget } from "@/components/sections/DividendWidget";
import { Watchlist } from "@/components/sections/Watchlist";
import { TrendingStocks } from "@/components/sections/TrendingStocks";
import { LatestTransactions } from "@/components/sections/LatestTransactions";

export default async function StocksPage() {
  const data = await fetchStocks();
  return (
    <div className="grid grid-cols-1 gap-6 xl:grid-cols-[1fr_360px]">
      <section className="space-y-6">
        <StatCards stats={data.stats} />
        <PortfolioPerformance series={data.portfolioSeries} />
        <TrendingStocks items={data.trending} />
        <LatestTransactions items={data.transactions} />
      </section>
      <aside className="space-y-6">
        <DividendWidget points={data.dividends} />
        <Watchlist items={data.watchlist} />
      </aside>
    </div>
  );
}