import { CommentModel } from './Comment';

export interface Post {
  id: number;
  user: string;
  avatar: string;
  level: string;
  date: string;
  content: string;
  image?: string;
  likes: number;
  liked: boolean;
  comments: CommentModel[];
}
