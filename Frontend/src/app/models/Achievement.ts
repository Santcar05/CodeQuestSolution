export interface Achievement {
  id: number;
  name: string;
  description?: string;
  category: string;
  rarity: 'Común' | 'Raro' | 'Épico' | 'Legendario' | 'Mítico';
  points: number;
  image: string;
  unlocked: boolean;
  requirements?: string;
  unlockDate?: Date;
}
