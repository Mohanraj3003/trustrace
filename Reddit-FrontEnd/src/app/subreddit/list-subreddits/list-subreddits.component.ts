import { SubredditRes } from "src/app/subreddit/subreddit-response";
import { Component, OnInit } from "@angular/core";
import { SubredditModel } from "../subreddit-request";
import { SubredditService } from "../subreddit.service";
import { throwError } from "rxjs";

@Component({
  selector: "app-list-subreddits",
  templateUrl: "./list-subreddits.component.html",
  styleUrls: ["./list-subreddits.component.css"],
})
export class ListSubredditsComponent implements OnInit {
  subreddits: Array<SubredditRes>;
  constructor(private subredditService: SubredditService) {}

  ngOnInit() {
    this.subredditService.getAllSubreddits().subscribe(
      (data) => {
        console.log(data);
        this.subreddits = data;
      },
      (error) => {
        throwError(error);
      }
    );
  }
}
