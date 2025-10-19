export interface RoadmapItem {
  id: number;
  title: string;
  description: string;
  icon: string;
  status: 'completed' | 'current' | 'upcoming';
  courses?: number;
  xp?: number;
  duration?: string;
}
