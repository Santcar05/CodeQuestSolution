export interface ExamResults {
  score: number;
  totalQuestions: number;
  correctAnswers: number;
  timeSpent: string;
  passed: boolean;
  details: {
    questionId: number;
    correct: boolean;
    userAnswer: string;
    correctAnswer: string;
    explanation: string;
  }[];
}
