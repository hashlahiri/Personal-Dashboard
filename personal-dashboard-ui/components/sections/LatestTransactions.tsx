import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import type { Transaction } from "@/lib/types";

const fmt = (iso: string) => new Date(iso).toLocaleString();

export function LatestTransactions({ items }: { items: Transaction[] }) {
  return (
    <Card>
      <CardHeader>
        <CardTitle>Market Transactions</CardTitle>
      </CardHeader>
      <CardContent>
        <div className="overflow-x-auto">
          <table className="w-full text-left text-sm">
            <thead className="text-xs text-zinc-500">
              <tr>
                <th className="px-2 py-2">Name</th>
                <th className="px-2 py-2">Date</th>
                <th className="px-2 py-2">Price</th>
                <th className="px-2 py-2">Category</th>
                <th className="px-2 py-2">Status</th>
              </tr>
            </thead>
            <tbody>
              {items.map((t) => (
                <tr key={t.id} className="border-t border-zinc-100 dark:border-zinc-800">
                  <td className="px-2 py-3">{t.label}</td>
                  <td className="px-2 py-3">{fmt(t.date)}</td>
                  <td className="px-2 py-3">${t.price.toLocaleString()}</td>
                  <td className="px-2 py-3">{t.category}</td>
                  <td className="px-2 py-3">
                    <span className={
                      t.status === "Success" ? "text-emerald-600" :
                      t.status === "Pending" ? "text-amber-600" : "text-rose-600"
                    }>{t.status}</span>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </CardContent>
    </Card>
  );
}
