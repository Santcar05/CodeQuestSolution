export interface RoadmapPhase {
  id: number;
  title: string;
  description: string;
  icon: string;
  status: 'completado' | 'activo' | 'pendiente';
  objectives: string[];
  xp: number;
  duration: string;
  resources: string[];
}
