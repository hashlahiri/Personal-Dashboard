import { buildBackendUrl } from "@/lib/utils";
import { toWeatherData } from "@/lib/utils";
import type { WeatherData, RawWeatherApiResponse } from "@/lib/types";
import { ENDPOINTS } from "@/lib/endpoints";

const BASE = process.env.NEXT_PUBLIC_API_BASE_URL;

export async function getWeather(
  city: string,
  countryCode: string
): Promise<WeatherData> {
  const url = new URL(buildBackendUrl(BASE, ENDPOINTS.weather));
  url.searchParams.set("city", city);
  url.searchParams.set("countryCode", countryCode);

  const res = await fetch(url.toString(), { cache: "no-store" });
  if (!res.ok) throw new Error("Failed to fetch weather");
  const raw = (await res.json()) as RawWeatherApiResponse;
  return toWeatherData(raw, city, countryCode);
}