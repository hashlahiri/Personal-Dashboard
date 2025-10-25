import { Card, CardContent } from "@/components/ui/card";
import { Badge } from "@/components/ui/badge";
import type { Stat } from "@/lib/types";
import { CheckCircle2, TrendingDown, TrendingUp, Wallet, Car, ShoppingCart, Apple } from "lucide-react";

const iconMap = { apple: Apple, wallet: Wallet, car: Car, shoppingCart: ShoppingCart };

export function StatCards({ stats }: { stats: Stat[] }) {
  return (
    <div className="grid grid-cols-1 gap-4 md:grid-cols-2 xl:grid-cols-4">
      {stats.map((s) => {
        const Icon = (iconMap as any)[s.icon || "checkCircle2"] || CheckCircle2;
        return (
          <Card key={s.id}>
            <CardContent className="flex items-center justify-between gap-3 py-5">
              <div className="flex items-center gap-3">
                <div className="rounded-full bg-zinc-100 p-2 dark:bg-zinc-800">
                  <Icon className="h-5 w-5" />
                </div>
                <div>
                  <div className="text-sm font-medium">{s.title}</div>
                  <div className="text-xs text-zinc-500">{s.subtitle}</div>
                </div>
              </div>
              <div className="text-right">
                <div className="text-lg font-semibold">${s.value.toLocaleString()}</div>
                {typeof s.delta === "number" && (
                  <Badge color={s.positive ? "green" : "red"}>
                    {s.positive ? <TrendingUp className="h-3 w-3" /> : <TrendingDown className="h-3 w-3" />}
                    {s.delta.toFixed(2)}%
                  </Badge>
                )}
              </div>
            </CardContent>
          </Card>
        );
      })}
    </div>
  );
}
