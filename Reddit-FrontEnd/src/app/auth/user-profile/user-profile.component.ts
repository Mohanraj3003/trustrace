import { Component, OnInit } from "@angular/core";
import { PostService } from "src/app/shared/post.service";
import { ActivatedRoute } from "@angular/router";
import { CommentService } from "src/app/comment/comment.service";
import { PostModel } from "src/app/shared/post-response";
import { CommentPayload } from "src/app/comment/comment.payload";
import { UserResponse } from "./user-Model";
import * as moment from "moment";

@Component({
  selector: "app-user-profile",
  templateUrl: "./user-profile.component.html",
  styleUrls: ["./user-profile.component.css"],
})
export class UserProfileComponent implements OnInit {
  name: string;
  posts: Array<PostModel> = [];
  comments: CommentPayload[];
  postLength: number;
  user: UserResponse;
  listpost: string[];
  constructor(
    private activatedRoute: ActivatedRoute,
    private postService: PostService,
    private commentService: CommentService
  ) {
    this.name = this.activatedRoute.snapshot.params.name;

    this.postService.getByUser(this.name).subscribe((data: UserResponse) => {
      this.user = data;
      this.postLength = this.user.posts.length;
      this.user.posts.forEach((element: string) => {
        this.postService.getPost(element).subscribe((data: PostModel) => {
          if (data.createdAt) {
            data.createdAt = moment.unix(parseInt(data.createdAt)).fromNow();
            this.posts.push(data);
          }
        });
      });
    });
  }
  ngOnInit(): void {}
}
