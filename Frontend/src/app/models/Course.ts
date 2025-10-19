import { Instructor } from './Instructor';
import { Review } from './Review';
import { ModuleModel } from './ModuleModel';

export interface Course {
  id: number;
  title: string;
  description: string;
  category: string;
  level: string;
  rating?: number;
  duration?: string;
  students?: number;
  lessons?: number;
  completedLessons?: number;
  nextLesson?: string;
  thumbnail?: string;
  image?: string;
  price?: string;
  originalPrice?: string;
  xp?: number;
  isNew?: boolean;
  isTrending?: boolean;
  status?: 'completed' | 'in-progress' | 'not-started';
  instructor?: Instructor;
  learningPoints?: string[];
  requirements?: string[];
  modules?: ModuleModel[];
  reviewsList?: Review[];
  totalPoints: number;
  difficulty?: string;
  preRequisites?: Course[];
  tags?: string[];
}
