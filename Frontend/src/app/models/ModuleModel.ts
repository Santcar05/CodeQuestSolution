import { Topic } from './Topic';

export interface ModuleModel {
  id: number;
  title: string;
  description?: string;
  duration?: string;
  points?: number;
  progress?: number;
  completed?: boolean;
  topics: Topic[];
}
