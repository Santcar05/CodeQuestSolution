export interface TestCase {
  id: number;
  title: string;
  description: string;
  status: 'pasado' | 'fallado' | 'no-ejecutado';
  type: 'automatico' | 'personalizado';
}
