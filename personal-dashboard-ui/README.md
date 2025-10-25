# Personal Dashboard — Next.js
A Next.js (App Router) using Tailwind CSS 

# install deps
npm i

# start dev server (hot reload)
npm run dev    # -> http://localhost:3000

npm run build  # production build
npm start      # run the production build
npm run lint   # check code style

## Connect APIs

- Edit **`lib/api.ts`** — swap `fetchDashboard()` to hit your endpoints.
- Provide `NEXT_PUBLIC_API_BASE_URL` in `.env.local` if different from default.

```ts
type DashboardData = { /* stats, portfolioSeries, trending, transactions, watchlist, dividends */ };
```

## Project structure

personal-dashboard-ui/
├─ app/                   # Next.js "App Router" pages & layout (server-first)
│  ├─ layout.tsx          # The global shell: Sidebar + Topbar + <main/>
│  └─ page.tsx            # The dashboard page (fetches data + renders sections)
├─ components/            # Reusable UI and sections
│  ├─ layout/Sidebar.tsx  # Left navigation (icons, active state)
│  ├─ layout/Topbar.tsx   # Top search + profile
│  ├─ sections/           # Dashboard blocks (cards, charts, tables…)
│  │  ├─ StatCards.tsx
│  │  ├─ PortfolioPerformance.tsx    # line chart
│  │  ├─ DividendWidget.tsx          # bar chart
│  │  ├─ TrendingStocks.tsx
│  │  └─ LatestTransactions.tsx
│  └─ ui/                 # primitives
│     ├─ card.tsx
│     ├─ button.tsx
│     └─ badge.tsx
├─ lib/
│  ├─ api.ts              # API calls (reads .env, with fallback)
│  ├─ types.ts            # TypeScript shapes used by the UI
│  └─ mockData.ts         # Local data so the UI renders
├─ app/globals.css        # Tailwind + base styles (rounded cards, dark mode)
├─ tailwind.config.ts     # Tailwind scanning paths + theme tweaks
├─ postcss.config.mjs     # Tailwind + autoprefixer
├─ .env.example           # Set NEXT_PUBLIC_API_BASE_URL here if needed
├─ next.config.js         # Next.js config
├─ tsconfig.json          # TypeScript config
├─ package.json           # scripts & dependencies
└─ README.md              # quick information

## Styling

- Tailwind CSS with a soft, glassy look (rounded-2xl, subtle borders, dark mode-ready).
- UI primitives in `components/ui/*` to keep the code tidy

## Notes

- Charting uses **recharts**
- The dashboard renders mock data if the API is unavailable, so the UI never blocks local dev.
- Replace sections or add routes (e.g., `/stocks`, `/weather`, `/json-compare`) as backend expands





