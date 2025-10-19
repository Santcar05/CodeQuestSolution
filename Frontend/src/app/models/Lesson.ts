import { LessonContent } from './LessonContent';

export interface Lesson {
  id: number;
  title: string;
  duration?: string;
  completed?: boolean;
  isPreview?: boolean;
  content?: LessonContent;
}
