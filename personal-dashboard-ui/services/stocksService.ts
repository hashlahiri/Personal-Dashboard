import { mockDashboard } from "@/lib/mockData";
import { StocksData } from "@/lib/types";

const BASE = process.env.NEXT_PUBLIC_API_BASE_URL;

export async function fetchStocks(): Promise<StocksData> {
  try {
    const res = await fetch(`${BASE}/stocks`, { cache: "no-store" });
    if (!res.ok) throw new Error("Bad status " + res.status);
    return (await res.json());
  } catch {
    return mockDashboard;
  }
}