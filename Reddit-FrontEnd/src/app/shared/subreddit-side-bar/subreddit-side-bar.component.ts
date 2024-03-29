import { SubredditRes } from "./../../subreddit/subreddit-response";
import { Component, OnInit } from "@angular/core";
import { SubredditService } from "src/app/subreddit/subreddit.service";
import { SubredditModel } from "src/app/subreddit/subreddit-request";

@Component({
  selector: "app-subreddit-side-bar",
  templateUrl: "./subreddit-side-bar.component.html",
  styleUrls: ["./subreddit-side-bar.component.css"],
})
export class SubredditSideBarComponent implements OnInit {
  subreddits: SubredditRes[];
  displayViewAll: boolean = false;

  constructor(private subredditService: SubredditService) {
    this.subredditService.getAllSubreddits().subscribe((data) => {
      if (data.length > 3) {
        this.subreddits = data.splice(0, 2);
        this.displayViewAll = true;
      } else {
        this.subreddits = data;
      }
    });
  }

  ngOnInit(): void {}
}
