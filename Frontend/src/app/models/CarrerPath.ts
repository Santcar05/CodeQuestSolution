import { RoadmapItem } from './RoadMapItem';

export interface CareerPath {
  id: number;
  title: string;
  subtitle?: string;
  description: string;
  icon?: string;
  role?: string;
  level?: string;
  totalXP?: number;
  currentXP?: number;
  requiredXP?: number;
  salaryRange?: string;
  selected?: boolean;
  opportunities?: string[];
  technologies?: string[];
  roadmap?: RoadmapItem[];
}
