"use client";

import { useState, useEffect } from "react";
import { Cloud, Sun, Moon, CloudRain, CloudSnow, CloudLightning, Droplets, Wind } from "lucide-react";
import { motion } from "framer-motion";
import { getWeather } from "@/services/weatherService";
import type { WeatherData } from "@/lib/types";

let ongoingWeatherFetch: Promise<WeatherData | null> | null = null;

const WeatherIcon = ({ description }: { description: string }) => {
  const getIcon = () => {
    const desc = description.toLowerCase();
    if (desc.includes("rain")) return CloudRain;
    if (desc.includes("snow")) return CloudSnow;
    if (desc.includes("thunder")) return CloudLightning;
    if (desc.includes("clear")) return Sun;
    if (desc.includes("night") || desc.includes("evening")) return Moon;
    return Cloud;
  };

  const Icon = getIcon();
  return <Icon className="h-16 w-16 text-blue-500" />;
};

export function WeatherWidget() {
  const [weather, setWeather] = useState<WeatherData | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    async function loadWeather() {
      setLoading(true);
      setError(null);
      try {
        if (!ongoingWeatherFetch) {
          ongoingWeatherFetch = getWeather("florence", "IT");
        }
        const data = await ongoingWeatherFetch;
        // clear the module-level promise so future calls re-fetch on demand
        ongoingWeatherFetch = null;

        if (data) setWeather(data);
      } catch (err) {
        ongoingWeatherFetch = null;
        setError("Failed to load weather data");
      } finally {
        setLoading(false);
      }
    }

    loadWeather();
    // Refresh every 5 minutes
    const interval = setInterval(loadWeather, 5 * 60 * 1000);
    return () => clearInterval(interval);
  }, []);

  if (loading) {
    return (
      <motion.div
        initial={{ opacity: 0 }}
        animate={{ opacity: 1 }}
        className="relative overflow-hidden rounded-xl border border-zinc-200/60 bg-gradient-to-br from-blue-50/50 to-blue-100/50 p-8 backdrop-blur-xl dark:border-zinc-800/60 dark:from-blue-950/20 dark:to-blue-900/20"
      >
        <div className="flex items-center justify-center space-x-2">
          <motion.div
            animate={{ rotate: 360 }}
            transition={{ duration: 2, repeat: Infinity, ease: "linear" }}
          >
            <Cloud className="h-8 w-8 text-blue-400/70" />
          </motion.div>
          <span className="text-zinc-600 dark:text-zinc-400">
            Loading weather...
          </span>
        </div>
      </motion.div>
    );
  }

  if (error) {
    return (
      <motion.div
        initial={{ opacity: 0 }}
        animate={{ opacity: 1 }}
        className="rounded-xl border border-red-200/60 bg-red-50/50 p-8 backdrop-blur dark:border-red-800/60 dark:bg-red-900/20"
      >
        {error}
      </motion.div>
    );
  }

  if (!weather) return null;

  return (
    <motion.div
      initial={{ opacity: 0, y: 20 }}
      animate={{ opacity: 1, y: 0 }}
      transition={{ duration: 0.5 }}
      className="relative overflow-hidden rounded-xl border border-zinc-200/60 bg-gradient-to-br from-blue-50/50 to-blue-100/50 p-8 backdrop-blur-xl dark:border-zinc-800/60 dark:from-blue-950/20 dark:to-blue-900/20"
    >
      <motion.div
        className="absolute -right-16 -top-16 h-48 w-48 rounded-full bg-yellow-200/20 blur-3xl dark:bg-blue-500/10"
        animate={{
          scale: [1, 1.2, 1],
          opacity: [0.3, 0.5, 0.3],
        }}
        transition={{
          duration: 8,
          repeat: Infinity,
          repeatType: "reverse",
        }}
      />

      <div className="relative space-y-6">
        <div className="flex items-start justify-between">
          <div>
            <motion.h2
              initial={{ opacity: 0, x: -20 }}
              animate={{ opacity: 1, x: 0 }}
              className="text-2xl font-bold"
            >
              {weather.city}, {weather.country}
            </motion.h2>
            <motion.p
              initial={{ opacity: 0 }}
              animate={{ opacity: 1 }}
              className="mt-1 text-sm text-zinc-600 dark:text-zinc-400"
            >
              {new Date().toLocaleDateString("en-US", {
                weekday: "long",
                year: "numeric",
                month: "long",
                day: "numeric",
              })}
            </motion.p>
          </div>
          <motion.div
            initial={{ scale: 0 }}
            animate={{ scale: 1 }}
            transition={{ type: "spring", stiffness: 200, damping: 15 }}
            className="text-4xl font-bold tabular-nums"
          >
            {Math.round(weather.temperature)}°C
          </motion.div>
        </div>

        <div className="flex items-center gap-6">
          <motion.div
            initial={{ opacity: 0, rotate: -20 }}
            animate={{ opacity: 1, rotate: 0 }}
            transition={{ duration: 0.5 }}
          >
            <WeatherIcon description={weather.description} />
          </motion.div>
          <motion.p
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            className="text-lg capitalize text-zinc-600 dark:text-zinc-400"
          >
            {weather.description}
          </motion.p>
        </div>

        <motion.div
          initial={{ opacity: 0, y: 20 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ delay: 0.2 }}
          className="grid grid-cols-2 gap-6"
        >
          <div className="flex items-center gap-3">
            <div className="rounded-full bg-blue-100/50 p-3 dark:bg-blue-900/50">
              <Droplets className="h-5 w-5 text-blue-500" />
            </div>
            <div>
              <p className="text-sm text-zinc-600 dark:text-zinc-400">
                Humidity
              </p>
              <p className="text-lg font-semibold tabular-nums">
                {weather.humidity}%
              </p>
            </div>
          </div>
          <div className="flex items-center gap-3">
            <div className="rounded-full bg-blue-100/50 p-3 dark:bg-blue-900/50">
              <Wind className="h-5 w-5 text-blue-500" />
            </div>
            <div>
              <p className="text-sm text-zinc-600 dark:text-zinc-400">
                Wind Speed
              </p>
              <p className="text-lg font-semibold tabular-nums">
                {weather.windSpeed} km/h
              </p>
            </div>
          </div>
        </motion.div>
      </div>
    </motion.div>
  );
}
