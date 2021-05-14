import { AuthService } from "./../../auth/shared/auth.service";
import { CommentRequest } from "./../../comment/comment-request";
import { Component, OnInit } from "@angular/core";
import { PostService } from "src/app/shared/post.service";
import { ActivatedRoute, Router } from "@angular/router";
import { PostModel } from "src/app/shared/post-response";
import { throwError } from "rxjs";
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { CommentPayload } from "src/app/comment/comment.payload";
import { CommentService } from "src/app/comment/comment.service";
import * as moment from "moment";

@Component({
  selector: "app-view-post",
  templateUrl: "./view-post.component.html",
  styleUrls: ["./view-post.component.css"],
})
export class ViewPostComponent implements OnInit {
  postId: string;
  post: PostModel;
  commentForm: FormGroup;
  comment: CommentRequest;
  comments: CommentPayload[];

  constructor(
    private postService: PostService,
    private activateRoute: ActivatedRoute,
    private commentService: CommentService,
    private router: Router,
    private authService: AuthService
  ) {
    this.postId = this.activateRoute.snapshot.params.id;

    this.commentForm = new FormGroup({
      text: new FormControl("", Validators.required),
    });

    this.comment = {
      userName: "",
      comment: "",
    };
  }

  ngOnInit(): void {
    this.getPostById();
  }

  postComment() {
    this.comment.comment = this.commentForm.get("text").value;
    this.comment.userName = this.authService.getUserName();
    this.commentService.postComment(this.comment, this.postId).subscribe(
      (data) => {
        this.commentForm.get("text").setValue("");
      },
      (error) => {
        throwError(error);
      }
    );
  }

  private getPostById() {
    this.postService.getPost(this.postId).subscribe(
      (data) => {
        this.post = data;
        console.log(this.post);
        if (this.post.createdAt)
          this.post.createdAt = moment
            .unix(parseInt(this.post.createdAt))
            .fromNow();

        if (this.post.comments) {
          this.post.comments.forEach((i) => {
            i.createdAt = moment.unix(parseInt(i.createdAt)).fromNow();
          });
        }
      },
      (error) => {
        throwError(error);
      }
    );
  }
}
