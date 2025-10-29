import { JsonKeyWidget } from "@/components/sections/JsonKeyWidget";
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
            <JsonKeyWidget />

            {/* more widgets go here … */}
          </div>
        </div>
      </div>
    </div>
  );
}
