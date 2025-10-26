import { WeatherWidget } from "@/components/sections/WeatherWidget";

export default function DashboardPage() {
  return (
    <div className="min-h-screen">
      <div className="max-w-screen-xl mx-auto p-6">
        <div className="flex flex-col md:flex-row items-start gap-6">
          {/* Left: small weather block (fixed width) */}
          <div className="w-full md:w-80">
            <div className="mx-auto md:mx-0">
              <WeatherWidget />
            </div>
          </div>

          {/* Right: (will fill remaining space for now - to be removed when adding more widgets on the homepage) */}
          <div className="flex-1 space-y-6">
            <div className="rounded-xl border border-zinc-200/60 bg-white/60 p-6 backdrop-blur dark:border-zinc-800/60 dark:bg-zinc-900/40">
              <p className="text-sm text-zinc-600 dark:text-zinc-400">Other width area for now</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
