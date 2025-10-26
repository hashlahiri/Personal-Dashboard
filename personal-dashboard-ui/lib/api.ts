import { mockDashboard } from "@/lib/mockData";
import type { StocksData, WeatherData, RawWeatherApiResponse } from "@/lib/types";
import { toWeatherData, buildWeatherApiUrl } from "@/lib/utils";

const BASE = process.env.API_BASE_URL || process.env.NEXT_PUBLIC_API_BASE_URL;

export async function fetchStocks(): Promise<StocksData> {
  try {
    const res = await fetch(`${BASE}/stocks`, { cache: "no-store" });
    if (!res.ok) throw new Error("Bad status " + res.status);
    return (await res.json());
  } catch {
    return mockDashboard;
  }
}

export async function fetchWeather(city: string, countryCode: string): Promise<WeatherData> {

  // API CALL
  const upstream = buildWeatherApiUrl(BASE, city, countryCode);
  const res = await fetch(upstream, { cache: "no-store" });
  if (!res.ok) throw new Error("Failed to fetch weather");

  const raw = (await res.json()) as RawWeatherApiResponse;
  return toWeatherData(raw, city, countryCode);
}
