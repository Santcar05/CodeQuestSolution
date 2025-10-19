export interface CommentModel {
  id: number;
  user: string;
  avatar: string;
  text: string;
  timestamp: Date;
  likes: number;
  image?: string;
}
