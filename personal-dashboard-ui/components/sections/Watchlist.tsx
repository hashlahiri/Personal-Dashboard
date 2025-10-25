import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import type { WatchItem } from "@/lib/types";
import { Badge } from "@/components/ui/badge";

export function Watchlist({ items }: { items: WatchItem[] }) {
  return (
    <Card>
      <CardHeader>
        <CardTitle>My Watchlist</CardTitle>
      </CardHeader>
      <CardContent className="space-y-3">
        {items.map((i) => (
          <div key={i.symbol} className="flex items-center justify-between">
            <div className="flex items-center gap-3">
              <div className="grid h-8 w-8 place-items-center rounded-full bg-zinc-100 text-xs font-semibold dark:bg-zinc-800">
                {i.symbol.slice(0, 2)}
              </div>
              <div>
                <div className="text-sm font-medium">{i.symbol}</div>
                <div className="text-xs text-zinc-500">{i.name}</div>
              </div>
            </div>
            <div className="text-right">
              <div className="text-sm font-semibold">${i.value.toLocaleString()}</div>
              <Badge color={i.changePct >= 0 ? "green" : "red"}>
                {(i.changePct >= 0 ? "+" : "") + i.changePct.toFixed(2)}%
              </Badge>
            </div>
          </div>
        ))}
      </CardContent>
    </Card>
  );
}
