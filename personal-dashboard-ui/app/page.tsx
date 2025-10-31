import { CarbonSection } from "@/components/sections/CarbonSection";
import { CryptoSection } from "@/components/sections/CryptoSection";
import { CurrencySection } from "@/components/sections/CurrencySection";
import { GeoSection } from "@/components/sections/GeoSection";
import { JsonKeySection } from "@/components/sections/JsonKeySection";
import { LaunchSection } from "@/components/sections/LaunchSection";
import { WeatherSection } from "@/components/sections/WeatherSection";
import { XkcdSection } from "@/components/sections/XkcdSection";

export default function DashboardPage() {
  return (
    <div className="min-h-screen">
      <div className="max-w-screen-xl mx-auto p-6">
        {/* ---------- masonry-gallery ---------- */}
        <div className="columns-1 md:columns-2 lg:columns-3 gap-6 pb-6">
          <div className="break-inside-avoid mb-6"><WeatherSection /></div>
          <div className="break-inside-avoid mb-6"><CurrencySection/></div>
          <div className="break-inside-avoid mb-6"><XkcdSection /></div>
          <div className="break-inside-avoid mb-6"><GeoSection /></div>
          <div className="break-inside-avoid mb-6"><JsonKeySection /></div>
          <div className="break-inside-avoid mb-6"><LaunchSection /></div>
          <div className="break-inside-avoid mb-6"><CarbonSection /></div>
          <div className="break-inside-avoid mb-6"><CryptoSection /></div>
        </div>
      </div>
    </div>
  );
}


