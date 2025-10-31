import { JsonKeyWidget } from "@/components/sections/JsonKeySection";
import { WeatherWidget } from "@/components/sections/WeatherSection";

export default function DashboardPage() {
  return (
    <div className="min-h-screen">
      <div className="max-w-screen-xl mx-auto p-6">
        {/* ---------- masonry-gallery ---------- */}
        <div className="columns-1 md:columns-2 lg:columns-3 gap-6">
          {/* 1. Weather  –  sticky top for skyline effect */}
          <div className="break-inside-avoid mb-6">
            <WeatherWidget />
          </div>

          {/* 2. JSON Key  –  natural flow */}
          <div className="break-inside-avoid mb-6">
            <JsonKeyWidget />
          </div>
        </div>
      </div>
    </div>
  );
}


