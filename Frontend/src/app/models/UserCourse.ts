import { Course } from './Course';
import { UserProfile } from './UserProfile';

export interface UserCourse {
  id?: number;
  userProfile: UserProfile;
  course: Course;
  status: 'COMPLETED' | 'IN_PROGRESS' | 'NOT_STARTED' | 'PAUSED';
  completedLessons?: number;
  nextLesson?: string;
  startedAt?: string;
  completedAt?: string | null;
  lastAccessed?: string;
  progressPercentage?: number;
  currentModule?: string;
  currentLesson?: string;
  rating?: number;
  isFavorite?: boolean;
  notes?: string;
}
