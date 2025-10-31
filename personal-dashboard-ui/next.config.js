/** @type {import('next').NextConfig} */
const nextConfig = {
  reactStrictMode: true,
  experimental: { typedRoutes: true, appDir: true },
  async rewrites() {
    return [
      {
        source: "/api/xkcd",
        destination: "https://xkcd.com/info.0.json",
      },
      {
        source: "/api/geo",
        destination: "https://ipapi.co/json",
      }
    ];
  },
};


module.exports = nextConfig;