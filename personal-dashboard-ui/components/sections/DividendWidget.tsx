"use client";

import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { BarChart, Bar, XAxis, YAxis, ResponsiveContainer, Tooltip } from "recharts";
import type { DividendPoint } from "@/lib/types";

export function DividendWidget({ points }: { points: DividendPoint[] }) {
  return (
    <Card>
      <CardHeader>
        <CardTitle>Stock Growth</CardTitle>
      </CardHeader>
      <CardContent className="h-[220px]">
        <ResponsiveContainer width="100%" height="100%">
          <BarChart data={points}>
            <XAxis dataKey="month" />
            <YAxis hide />
            <Tooltip />
            <Bar dataKey="value" />
          </BarChart>
        </ResponsiveContainer>
      </CardContent>
    </Card>
  );
}
