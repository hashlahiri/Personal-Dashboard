import { mockDashboard } from "@/lib/mockData";
import type { StocksData } from "@/lib/types";

const BASE = process.env.NEXT_PUBLIC_API_BASE_URL || "http://localhost:9000";

/**
 * Generic JSON fetcher with mock fallback.
 * Swap real endpoints here, GET `${BASE}/dashboard`
 */
export async function fetchStocks(): Promise<StocksData> {
  try {
    const res = await fetch(`${BASE}/dashboard`, { cache: "no-store" });
    if (!res.ok) throw new Error("Bad status " + res.status);
    return await res.json() as StocksData;
  } catch {
    return mockDashboard;
  }
}
