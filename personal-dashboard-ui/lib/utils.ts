import type { RawWeatherApiResponse, WeatherData } from "@/lib/types";

export function cn(...classes: Array<string | undefined | null | false>) { return classes.filter(Boolean).join(' '); }

const kelvinToC = (k?: number) => (typeof k === "number" ? +(k - 273.15).toFixed(1) : undefined);
const windMsToKmh = (m?: number) => (typeof m === "number" ? +(m * 3.6).toFixed(1) : 0);

// convert to response data - weather widget
export function toWeatherData(raw: RawWeatherApiResponse, fallbackCity: string, fallbackCountry: string): WeatherData {
  const description = raw.weather && raw.weather.length > 0 ? raw.weather[0].description : "N/A";
  const icon = raw.weather && raw.weather.length > 0 ? raw.weather[0].icon : undefined;

  return {
    temperature: kelvinToC(raw.main?.temp) ?? 0,
    feelsLike: kelvinToC(raw.main?.feels_like),
    tempMin: kelvinToC(raw.main?.temp_min),
    tempMax: kelvinToC(raw.main?.temp_max),
    pressure: raw.main?.pressure,
    humidity: raw.main?.humidity ?? 0,
    windSpeed: windMsToKmh(raw.wind?.speed),
    description,
    icon,
    city: raw.name ?? fallbackCity,
    country: raw.sys?.country ?? fallbackCountry,
  };
}

/**
 * Build the upstream weather API URL in one place so callers don't duplicate
 * the full path and query-encoding logic across the codebase.
 */
export function buildWeatherApiUrl(base: string | undefined, city: string, countryCode: string) {
  base = !base || base === "" ? "http://localhost:9000/personaldashboard" : base;
  return `${base.replace(/\/$/, '')}/api/currentWeather/cityStateCountry?city=${encodeURIComponent(city)}&countryCode=${encodeURIComponent(countryCode)}`;
}
