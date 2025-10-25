import type { StocksData } from "./types";

export const mockDashboard: StocksData = {
  stats: [
    { id: "aapl", title: "Apple, Inc", subtitle: "AAPL", value: 1232.0, delta: 11.01, positive: true, icon: "apple" },
    { id: "pypl", title: "Paypal, Inc", subtitle: "PYPL", value: 965.0, delta: -9.05, positive: false, icon: "wallet" },
    { id: "tsla", title: "Tesla, Inc", subtitle: "TSLA", value: 1232.0, delta: 11.01, positive: true, icon: "car" },
    { id: "amzn", title: "Amazon.com, Inc", subtitle: "AMZN", value: 2567.0, delta: 11.01, positive: true, icon: "shoppingCart" }
  ],
  portfolioSeries: Array.from({ length: 14 }).map((_, i) => ({
    date: `2026-${String(i+1).padStart(2, "0")}-01`,
    value: 30 + Math.sin(i / 2) * 5 + i * 0.8
  })),
  trending: [
    { symbol: "TSLA", name: "Tesla, Inc", price: 192.53, changePct: 1.01 },
    { symbol: "AAPL", name: "Apple, Inc", price: 192.53, changePct: 3.59 },
    { symbol: "SPOT", name: "Spotify, Inc", price: 312.42, changePct: -0.42 }
  ],
  transactions: [
    { id: "1", label: "Bought PYPL", date: "2025-11-23T13:00:00.000Z", price: 2567.88, category: "Finance", status: "Success" },
    { id: "2", label: "Bought AAPL", date: "2025-11-23T13:00:00.000Z", price: 2567.88, category: "Finance", status: "Pending" },
    { id: "3", label: "Sell KKST", date: "2025-11-23T13:00:00.000Z", price: 2567.88, category: "Finance", status: "Success" },
    { id: "4", label: "Bought FB", date: "2025-11-23T13:00:00.000Z", price: 2567.88, category: "Finance", status: "Success" },
    { id: "5", label: "Sell AMZN", date: "2025-11-23T13:00:00.000Z", price: 2567.88, category: "Finance", status: "Failed" }
  ],
  watchlist: [
    { symbol: "AAPL", name: "Apple, Inc", value: 4008.65, changePct: 11.01 },
    { symbol: "SPOT", name: "Spotify.com", value: 11689.0, changePct: 9.48 },
    { symbol: "ABNB", name: "Airbnb, Inc", value: 32227.0, changePct: -0.29 },
    { symbol: "ENVT", name: "Envato, Inc", value: 13895.0, changePct: 3.79 },
    { symbol: "QIWI", name: "qiwi.com, Inc", value: 4008.65, changePct: -4.52 }
  ],
  dividends: [
    { month: "Jan", value: 100 },
    { month: "Feb", value: 380 },
    { month: "Mar", value: 200 },
    { month: "Apr", value: 320 },
    { month: "May", value: 210 },
    { month: "Jun", value: 240 }
  ]
};
