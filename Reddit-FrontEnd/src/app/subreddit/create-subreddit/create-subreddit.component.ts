import { AuthService } from "src/app/auth/shared/auth.service";
import { Component, OnInit } from "@angular/core";
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { SubredditModel } from "../subreddit-request";
import { Router } from "@angular/router";
import { SubredditService } from "../subreddit.service";
import { throwError } from "rxjs";

@Component({
  selector: "app-create-subreddit",
  templateUrl: "./create-subreddit.component.html",
  styleUrls: ["./create-subreddit.component.css"],
})
export class CreateSubredditComponent implements OnInit {
  createSubredditForm: FormGroup;
  subredditModel: SubredditModel;
  title = new FormControl("");
  description = new FormControl("");

  constructor(
    private router: Router,
    private subredditService: SubredditService,
    private authService: AuthService
  ) {
    this.createSubredditForm = new FormGroup({
      title: new FormControl("", Validators.required),
      description: new FormControl("", Validators.required),
    });
    this.subredditModel = {
      subredditName: "",
      description: "",
      UserName: "",
    };
  }

  ngOnInit() {}

  discard() {
    this.router.navigateByUrl("/");
  }

  createSubreddit() {
    this.subredditModel.subredditName = this.createSubredditForm.get(
      "title"
    ).value;
    this.subredditModel.description = this.createSubredditForm.get(
      "description"
    ).value;

    this.subredditModel.UserName = this.authService.getUserName();
    this.subredditService.createSubreddit(this.subredditModel).subscribe(
      (data) => {
        this.router.navigateByUrl("/list-subreddits");
      },
      (error) => {
        throwError(error);
      }
    );
  }
}
