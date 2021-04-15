
export interface Receipt {
  id?: string;
  title: string;
  description: string;
  author?: string;
  imageUrl?: string;
  imageFile?: string;
  hashes?: string[];
  ingredients?: Ingredient[];
  steps?: ReceiptStep[];
}

export interface ReceiptStep {
  id?: string;
  recipeId?: string;
  orderNumber: number;
  title: string;
  description: string;
  imageUrl: string;
}

export interface Ingredient {
  recipeId?: string;
  id?: string;
  name: string;
  measure?: string;
  amount: string;
}

export interface Category {
  id: string;
  name: string;
}

export interface SearchReceipt {
  query?: string;
  ingredients?: string[];
  category?: string[];
}
