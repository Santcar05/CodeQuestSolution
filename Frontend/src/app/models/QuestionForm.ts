import { OptionForm } from './OptionForm';

export interface QuestionForm {
  question: string;
  answer: string;
  id: number;
  options: OptionForm[];
  selectedOption: number | null;
}
