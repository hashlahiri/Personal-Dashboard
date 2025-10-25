import type { Config } from "tailwindcss";

export default {
  darkMode: ["class"],
  content: [
    "./app/**/*.{ts,tsx}",
    "./components/**/*.{ts,tsx}",
    "./lib/**/*.{ts,tsx}"
  ],
  theme: {
    extend: {
      colors: { bg: { light: "#F5F6FA", dark: "#0B0D12" } },
      boxShadow: { card: "0 2px 12px -2px rgba(0,0,0,0.08)" }
    }
  },
  plugins: []
} satisfies Config;
