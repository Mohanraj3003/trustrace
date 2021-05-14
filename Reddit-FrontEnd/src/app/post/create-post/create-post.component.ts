import { AuthService } from "src/app/auth/shared/auth.service";
import { Component, OnInit } from "@angular/core";
import { FormGroup, Validators, FormControl } from "@angular/forms";
import { SubredditModel } from "src/app/subreddit/subreddit-request";
import { Router } from "@angular/router";
import { PostService } from "src/app/shared/post.service";
import { SubredditService } from "src/app/subreddit/subreddit.service";
import { throwError } from "rxjs";
import { CreatePostPayload } from "./create-post.payload";
import { SubredditRes } from "src/app/subreddit/subreddit-response";

@Component({
  selector: "app-create-post",
  templateUrl: "./create-post.component.html",
  styleUrls: ["./create-post.component.css"],
})
export class CreatePostComponent implements OnInit {
  createPostForm: FormGroup;
  postPayload: CreatePostPayload;
  subreddits: Array<SubredditRes>;

  constructor(
    private router: Router,
    private postService: PostService,
    private subredditService: SubredditService,
    private authService: AuthService
  ) {
    this.postPayload = {
      postName: "",
      userName: "",
      url: "",
      description: "",
      subredditName: "",
    };
  }

  ngOnInit() {
    this.createPostForm = new FormGroup({
      postName: new FormControl("", Validators.required),
      subredditName: new FormControl("", Validators.required),
      url: new FormControl("", Validators.required),
      description: new FormControl("", Validators.required),
    });
    this.subredditService.getAllSubreddits().subscribe(
      (data) => {
        this.subreddits = data;
      },
      (error) => {
        throwError(error);
      }
    );
  }

  createPost() {
    this.postPayload.postName = this.createPostForm.get("postName").value;
    this.postPayload.subredditName = this.createPostForm.get(
      "subredditName"
    ).value;
    this.postPayload.url = this.createPostForm.get("url").value;
    this.postPayload.description = this.createPostForm.get("description").value;
    this.postPayload.userName = this.authService.getUserName();

    this.postService.createPost(this.postPayload).subscribe(
      (data) => {
        console.log(data);
        this.router.navigateByUrl("/");
      },
      (error) => {
        throwError(error);
      }
    );
  }

  discardPost() {
    this.router.navigateByUrl("/");
  }
}
