export interface Badge {
  id: number;
  name: string;
  description: string;
  icon: string;
  earned: boolean;
  xp?: number;
  category?: string;
}
