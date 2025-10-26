"use client";

import { Moon, Sun, LayoutDashboard, House, ChartCandlestick, ShoppingCart, Menu, Map } from "lucide-react";
import { useState, useEffect } from "react";
import Link from "next/link";
import { usePathname } from "next/navigation";

const nav = [
  { href: "/", label: "Dashboard", icon: House },
  { href: "/stocks", label: "Stocks", icon: ChartCandlestick },
  { href: "/ecommerce", label: "Shopping", icon: ShoppingCart },
  { href: '/maurauders-map', label: "Marauders Map", icon: Map },
];

export function Topbar() {
  const [isOpen, setIsOpen] = useState(false);
  const [theme, setTheme] = useState<'light' | 'dark'>('light');
  const pathname = usePathname();

  useEffect(() => {
    // On mount, read theme from localStorage or system preference
    const savedTheme = localStorage.getItem('theme');
    const prefersDark = window.matchMedia('(prefers-color-scheme: dark)').matches;
    
    const initialTheme = savedTheme || (prefersDark ? 'dark' : 'light');
    setTheme(initialTheme as 'light' | 'dark');
    document.documentElement.classList.toggle('dark', initialTheme === 'dark');
  }, []);

  const toggleTheme = () => {
    const newTheme = theme === 'light' ? 'dark' : 'light';
    setTheme(newTheme);
    localStorage.setItem('theme', newTheme);
    document.documentElement.classList.toggle('dark', newTheme === 'dark');
  };

  return (
    <header className="sticky top-0 z-40 bg-white/10 backdrop-blur-md backdrop-saturate-150 supports-[backdrop-filter]:bg-white/5 dark:border-zinc-800/20 dark:bg-zinc-900/10">
      <div className="mx-auto max-w-screen-xl px-4 py-3">
        <div className="flex items-center justify-center gap-4">
          <div className="relative">
            <button 
              onClick={() => setIsOpen(!isOpen)} 
              className="btn btn-ghost rounded-full p-2 hover:bg-white/10" 
              aria-label="Navigation menu"
            >
              <Menu className="h-5 w-5" />
            </button>
            
            {isOpen && (
              <div className="absolute left-0 mt-2 w-56 rounded-xl bg-white/10 p-2 backdrop-blur-md backdrop-saturate-150 supports-[backdrop-filter]:bg-white/5 dark:bg-zinc-900/10 border border-zinc-200/20 dark:border-zinc-800/20">
                <nav className="space-y-1">
                  {nav.map((item) => {
                    const Icon = item.icon;
                    const active = pathname === item.href;
                    return (
                      <Link
                        key={item.href}
                        href={item.href as any}
                        className={`flex items-center gap-3 rounded-lg px-3 py-2 text-sm transition-colors hover:bg-white/10 dark:hover:bg-zinc-800/30 ${
                          active ? 'bg-white/10 dark:bg-zinc-800/30 font-medium' : ''
                        }`}
                        onClick={() => setIsOpen(false)}
                      >
                        <Icon className="h-4 w-4" />
                        {item.label}
                      </Link>
                    );
                  })}
                </nav>
              </div>
            )}
          </div>

          <div className="flex items-center gap-2">
            <Link href="/"><LayoutDashboard className="h-6 w-6" /></Link>
          </div>
          
          <button 
            onClick={toggleTheme}
            className="btn btn-ghost rounded-full p-2 hover:bg-white/10" 
            aria-label="Toggle theme"
          >
            {theme === 'light' ? (
              <Moon className="h-5 w-5" />
            ) : (
              <Sun className="h-5 w-5" />
            )}
          </button>
        </div>
      </div>
    </header>
  );
}
