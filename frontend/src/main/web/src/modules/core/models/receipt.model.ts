
export interface Receipt {
  id: string;
  title: string;
  description: string;
  author: string;
  url?: string;
  hashes?: string[];
  content?: ReceiptContent;
}

export interface Ingredient {
  name: string;
  quantity: string
  // TODO: add type (pcs, grams, etc)
}

export interface ReceiptContent {
  ingredients: Ingredient[];
  steps: string[];
  images?: string[];
}

