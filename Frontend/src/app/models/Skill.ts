export interface Skill {
  id?: number;
  name: string;
  level: number;
  target?: number;
  category?: 'tecnica' | 'blanda' | 'technical' | 'soft';
}
