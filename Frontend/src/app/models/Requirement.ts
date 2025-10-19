export interface Requirement {
  id: number;
  description: string;
  type: 'conocimiento' | 'curso' | 'habilidad';
  status: 'completado' | 'pendiente' | 'en-progreso';
  courseId?: number;
}
