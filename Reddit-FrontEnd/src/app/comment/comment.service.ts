import { CommentRequest } from "./comment-request";
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { CommentPayload } from "./comment.payload";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class CommentService {
  constructor(private httpClient: HttpClient) {}

  // getAllCommentsForPost(postId: number): Observable<CommentPayload[]> {
  //   return this.httpClient.get<CommentPayload[]>('http://localhost:8080/api/comments/by-post/' + postId);
  // }

  postComment(comment: CommentRequest, id: string): Observable<any> {
    return this.httpClient.post<any>(
      "http://localhost:8080/api/comments/" + id,
      comment
    );
  }

  // getAllCommentsByUser(name: string) {
  //   return this.httpClient.get<CommentPayload[]>('http://localhost:8080/api/comments/by-user/' + name);
  // }
}
