import { CodeExplanation } from './CodeExplanation';

export interface LessonContent {
  video?: string;
  audio?: string;
  document?: string;
  code?: string;
  mindmap?: string;
  interactive?: string;
  codeExplanations?: CodeExplanation[];
}
