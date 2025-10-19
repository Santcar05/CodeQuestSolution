import { Lesson } from './Lesson';

export interface Topic {
  id: number;
  title: string;
  description?: string;
  completed?: boolean;
  lessons: Lesson[];
}
