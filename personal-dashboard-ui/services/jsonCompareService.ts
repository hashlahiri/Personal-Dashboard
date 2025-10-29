import { buildBackendUrl } from "@/lib/utils";
import { ENDPOINTS } from "@/lib/endpoints";

const BASE = process.env.NEXT_PUBLIC_API_BASE_URL;

export async function checkJsonKeyExists(payload: string, parentKey: string, childKey: string ): Promise<boolean> {

  const res = await fetch(buildBackendUrl(BASE, ENDPOINTS.jsonExists), {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ payload, parentKey, childKey }),
  });

  if (!res.ok) throw new Error("Bad status " + res.status);

  const json: { exists: boolean } = await res.json();

  return json.exists;
}