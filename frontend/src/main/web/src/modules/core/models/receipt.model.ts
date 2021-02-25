
export interface Receipt {
  id: string;
  title: string;
  description: string;
  author: string;
  url?: string;
  hashes?: string[];
  content?: unknown;
}
