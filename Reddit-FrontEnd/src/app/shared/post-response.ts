import { CommentPayload } from "src/app/comment/comment.payload";

export class PostModel {
  id: string;
  postName: string;
  url: string;
  description: string;
  voteCount: number;
  userName: string;
  commentCount: number;
  createdAt: string;
  subredditId: string;
  comments: CommentPayload[];
}
