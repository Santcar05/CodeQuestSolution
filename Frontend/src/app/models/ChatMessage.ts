export interface ChatMessage {
  id: number;
  text: string;
  isUser: boolean;
  timestamp: Date;
  type?: 'sugerencia' | 'feedback' | 'pista' | 'evaluacion';
}
