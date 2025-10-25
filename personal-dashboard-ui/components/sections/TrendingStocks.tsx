import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import type { Stock } from "@/lib/types";
import { Button } from "@/components/ui/button";

export function TrendingStocks({ items }: { items: Stock[] }) {
  return (
    <Card>
      <CardHeader>
        <CardTitle>Trending Stocks</CardTitle>
      </CardHeader>
      <CardContent className="grid gap-3 md:grid-cols-2 xl:grid-cols-3">
        {items.map((s) => (
          <div key={s.symbol} className="rounded-xl border border-zinc-200/60 bg-white/60 p-4 dark:border-zinc-800/60 dark:bg-zinc-900/40">
            <div className="mb-3 text-sm font-semibold">{s.symbol}</div>
            <div className="mb-3 text-xs text-zinc-500">{s.name}</div>
            <div className="mb-4 text-lg font-semibold">${s.price.toFixed(2)}</div>
            <div className="flex items-center gap-2">
              <Button className="w-full">Buy Stock</Button>
              <Button className="w-full" variant="ghost">Short Stock</Button>
            </div>
          </div>
        ))}
      </CardContent>
    </Card>
  );
}
