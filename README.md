# Personal-Dashboard  
**Backend**: Spring Boot + MongoDB  
**Frontend**: Next.js 14 (React) + Tailwind CSS + TypeScript  
**Extras**: Redis Streams, Kafka, Docker Compose, open APIs

A modular, responsive dashboard that aggregates real-time data from multiple open APIs and displays it in a beautiful, glass-morphic interface.

---

## ✨  What’s New (v2)

| Feature | Tech Stack | Description |
|---------|------------|-------------|
| **Next.js 14 Dashboard** | React 18, App Router, TypeScript, Tailwind CSS | Server-side rendered UI with dark-mode support and responsive masonry grid. |
| **Glass-morphism UI** | Tailwind CSS, backdrop-blur, gradients** | Cards float above a blurred background with subtle gradients that adapt to light/dark mode. |
| **Weather Widget** | OpenWeatherMap API | Live city weather + 5-min auto-refresh. |
| **Currency Converter** | Frankfurter (ECB) API | Real-time FX rates with 24 h client cache. |
| **JSON Comparator** | Custom Spring Boot endpoint | Search a JSON key inside another JSON via REST. |
| **SpaceX Launch Timer** | SpaceX public API | Count-down to next Falcon 9 / Starship launch. |
| **UK Carbon Intensity** | carbonintensity.org.uk | Live grams of CO₂ per kWh with colour-coded badge. |
| **Today’s XKCD Comic** | xkcd.com (via internal proxy) | Auto-updates daily; no CORS issues. |
| **Redis Streams Micro-service** | Docker Compose, Node.js, GraphQL Subscriptions | Pushes chess moves to multiple dashboards in real-time (optional). |
| **Kafka Producer / Consumer** | Apache Kafka | Event-driven messaging pipeline (local dev). |
| **Docker Compose** | Redis, Node subscriber, Spring Boot | One-command `docker-compose up` spins up entire stack. |

---

## 🖼  Screenshots
<div align="center">
  <img src="https://github.com/hashlahiri/Personal-Dashboard/blob/main/personalDashboardApp%20-%20Screens/v2Nightlight.png" alt="Dashboard nightlight v2 preview" width="900">
</div> <br />
<div align="center">
  <img src="https://github.com/hashlahiri/Personal-Dashboard/blob/main/personalDashboardApp%20-%20Screens/WeatherData.png" alt="Dashboard backend implementation" width="900">
</div> <br />
<div align="center">
  <img src="https://github.com/hashlahiri/Personal-Dashboard/blob/main/personalDashboardApp%20-%20Screens/v2Daylight.png" alt="Dashboard daylight v2 preview" width="900">
</div>

---

## 🚀  Quick Start (Full Stack)

### 1. Clone
```bash
git clone https://github.com/hashlahiri/Personal-Dashboard.git
cd Personal-Dashboard
```

### 2. Backend (Spring Boot + MongoDB)
```bash
cd backend
./mvnw spring-boot:run
```
MongoDB URI: `mongodb://localhost:27017/personal_dashboard`

### 3. Frontend (Next.js)
```bash
cd frontend
npm install
npm run dev
```
Visit http://localhost:3000

### 4. Redis (optional real-time features)
```bash
docker-compose up -d   # redis + node-subscriber
```

### 5. Kafka (optional)
Follow the original Kafka setup guide in this README.

---

## 📦  Open APIs Used
| API | Purpose | Docs |
|-----|---------|------|
| OpenWeatherMap | Weather | https://openweathermap.org/api |
| Frankfurter (ECB) | Currency rates | https://www.frankfurter.app |
| SpaceX | Launch data | https://github.com/r-spacex/SpaceX-API |
| carbonintensity.org.uk | UK grid CO₂ | https://carbonintensity.org.uk |
| xkcd.com | Daily comic | https://xkcd.com/json.html |

---

## 🛠  Tech Stack at a Glance
| Layer | Tech |
|-------|------|
| Backend | Java 21, Spring Boot 3, MongoDB, Kafka, Redis |
| Frontend | Next.js 14, React 18, TypeScript, Tailwind CSS |
| DevOps | Docker Compose, Maven, npm |
| Styling | Glass-morphism, dark/light mode, responsive masonry |
| Real-time | Redis Streams → Node micro-service → GraphQL Subscriptions |

---

## 🤝  Contributing
PRs welcome!  
- Add a new open-API widget  
- Improve glass-morphism theme  
- Add tests (Jest / Spring-Boot Test)

---

## 📄  License
MIT © 2025 hashlahiri

---

## 🙏  Acknowledgments
Spring Boot, MongoDB, Next.js, Tailwind CSS, Redis, Kafka, OpenWeatherMap, Frankfurter, SpaceX, carbonintensity.org.uk, xkcd.com
