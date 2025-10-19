export interface PremiumPlan {
  id: number;
  name: string;
  description: string;
  price: string;
  period: string;
  savings: string;
  recommended: boolean;
  features: string[];
}
