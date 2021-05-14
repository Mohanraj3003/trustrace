import { Component, OnInit } from "@angular/core";
import * as moment from "moment";
import { PostModel } from "../shared/post-response";
import { PostService } from "../shared/post.service";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.css"],
})
export class HomeComponent implements OnInit {
  posts: Array<PostModel> = [];

  constructor(private postService: PostService) {
    this.postService.getAllPosts().subscribe((post) => {
      this.posts = post;
      this.convert();
    });
  }

  convert() {
    this.posts.forEach((val, index) => {
      if (val.createdAt) {
        this.posts[index].createdAt = moment
          .unix(parseInt(val.createdAt))
          .fromNow();
      }
    });
  }

  ngOnInit(): void {}
}
