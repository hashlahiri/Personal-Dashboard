import "./globals.css";
import type { Metadata } from "next";
import { Sidebar } from "@/components/layout/Sidebar";
import { Topbar } from "@/components/layout/Topbar";

export const metadata: Metadata = {
  title: "Personal Dashboard",
  description: "Personal Dashboard by Chanakya Lahiri"
};

export default function RootLayout({ children }: { children: React.ReactNode }) {
  return (
    <html lang="en" suppressHydrationWarning>
      <body className="min-h-screen antialiased">
        <div className="grid min-h-screen grid-cols-[260px_1fr]">
          <Sidebar />
          <div className="flex flex-col">
            <Topbar />
            <main className="p-6 md:p-8">{children}</main>
          </div>
        </div>
      </body>
    </html>
  );
}
