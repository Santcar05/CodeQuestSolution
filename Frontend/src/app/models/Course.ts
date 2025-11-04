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
  lessons?: number; // Total de lecciones del curso
  thumbnail?: string;
  image?: string;
  price?: string;
  originalPrice?: string;
  xp?: number;
  isNew?: boolean;
  isTrending?: boolean;
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
