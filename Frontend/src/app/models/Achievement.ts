export interface Achievement {
  id: number;
  name: string;
  description?: string;
  category: string;
  rarity: 'COMÚN' | 'RARO' | 'ÉPICO' | 'LEGENDARIO' | 'MÍTICO';
  points: number;
  image: string;
  unlocked: boolean;
  requirements?: string;
  unlockDate?: Date;
}
