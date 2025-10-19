export interface Question {
  id: number;
  title?: string;
  text?: string;
  type: 'teorica' | 'practica';
  options?: string[];
  correctAnswer: number | string;
  userAnswer?: number | string;
  codeTemplate?: string;
  explanation?: string;
  flagged?: boolean;
}
