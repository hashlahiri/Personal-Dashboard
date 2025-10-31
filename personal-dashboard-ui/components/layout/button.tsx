import * as React from "react";
import { cn } from "@/lib/utils";

type Props = React.ButtonHTMLAttributes<HTMLButtonElement> & {
  variant?: "primary" | "ghost";
};

export const Button = React.forwardRef<HTMLButtonElement, Props>(
  ({ className, variant = "primary", ...props }, ref) => {
    const base = variant === "primary" ? "btn btn-primary" : "btn btn-ghost";
    return <button ref={ref} className={cn(base, className)} {...props} />;
  }
);
Button.displayName = "Button";
