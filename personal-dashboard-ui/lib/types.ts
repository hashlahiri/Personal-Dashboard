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

// weather data response interface
export interface WeatherData {
  temperature: number; // Celsius
  feelsLike?: number; // Celsius
  tempMin?: number; // Celsius
  tempMax?: number; // Celsius
  pressure?: number; // hPa
  humidity: number; // percentage
  windSpeed: number; // km/h
  description: string;
  icon?: string;
  city: string;
  country: string;
}

// raw weather API response interface and helper interfaces
export interface Coord { lat: number; lon: number }
export interface Clouds { all: number }
export interface MainWeather { temp: number; feels_like: number; temp_min: number; temp_max: number; pressure: number; humidity: number }
export interface Wind { speed: number; deg?: number; gust?: number }
export interface Sys { country: string; sunrise?: number; sunset?: number }
export interface WeatherDesc { id: string; main: string; description: string; icon?: string }

export interface RawWeatherApiResponse {
  _id?: string;
  base?: string;
  clouds?: Clouds;
  cod?: string | number;
  coord?: Coord;
  dt?: string | number;
  id?: string | number;
  main?: MainWeather;
  name?: string;
  sys?: Sys;
  timezone?: number;
  visibility?: number;
  weather?: WeatherDesc[];
  wind?: Wind;
}
