import type { RawWeatherApiResponse, WeatherData } from "@/lib/types";
import { useEffect, RefObject } from 'react';

export function cn(...classes: Array<string | undefined | null | false>) {
  return classes.filter(Boolean).join(" ");
}

/* ---------- private helpers ---------- */
const kelvinToC = (k?: number) =>
  typeof k === "number" ? +(k - 273.15).toFixed(1) : undefined;

const windMsToKmh = (m?: number) =>
  typeof m === "number" ? +(m * 3.6).toFixed(1) : 0;

const normaliseBase = (base?: string) =>
  (base && base.trim() !== "" ? base : "http://localhost:9000/personaldashboard")
    .replace(/\/$/, ""); // remove trailing slash

/* ---------- public helpers ---------- */
export function toWeatherData(
  raw: RawWeatherApiResponse,
  fallbackCity: string,
  fallbackCountry: string
): WeatherData {
  const desc = raw.weather?.[0]?.description ?? "N/A";
  const icon = raw.weather?.[0]?.icon;

  return {
    temperature: kelvinToC(raw.main?.temp) ?? 0,
    feelsLike: kelvinToC(raw.main?.feels_like),
    tempMin: kelvinToC(raw.main?.temp_min),
    tempMax: kelvinToC(raw.main?.temp_max),
    pressure: raw.main?.pressure,
    humidity: raw.main?.humidity ?? 0,
    windSpeed: windMsToKmh(raw.wind?.speed),
    description: desc,
    icon,
    city: raw.name ?? fallbackCity,
    country: raw.sys?.country ?? fallbackCountry,
  };
}

/** Unified URL builder – always adds /api segment */
export function buildBackendUrl(
  base: string | undefined,
  endpoint: string
): string {
  const root = normaliseBase(base);
  const clean = endpoint.startsWith("/") ? endpoint.slice(1) : endpoint;
  return `${root}/api/${clean}`;
}

export function useClickOutside(
  ref: RefObject<HTMLElement>,
  handler: () => void
) {
  useEffect(() => {
    const listener = (e: MouseEvent | TouchEvent) => {
      if (!ref.current || ref.current.contains(e.target as Node)) return;
      handler();
    };
    document.addEventListener('mousedown', listener);
    document.addEventListener('touchstart', listener);
    return () => {
      document.removeEventListener('mousedown', listener);
      document.removeEventListener('touchstart', listener);
    };
  }, [ref, handler]);
}