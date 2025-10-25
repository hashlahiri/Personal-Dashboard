export type Stat = {
  id: string;
  title: string;
  subtitle?: string;
  value: number;
  delta?: number; // percentage
  positive?: boolean;
  icon?: string;
};

export type Stock = { symbol: string; name: string; price: number; changePct: number; };
export type Transaction = { id: string; label: string; date: string; price: number; category: string; status: "Success" | "Pending" | "Failed"; };
export type WatchItem = { symbol: string; name: string; value: number; changePct: number; };
export type DividendPoint = { month: string; value: number; };

export type StocksData = {
  stats: Stat[];
  portfolioSeries: Array<{ date: string; value: number }>;
  trending: Stock[];
  transactions: Transaction[];
  watchlist: WatchItem[];
  dividends: DividendPoint[];
};
