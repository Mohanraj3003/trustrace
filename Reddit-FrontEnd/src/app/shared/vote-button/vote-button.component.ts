import { Component, OnInit, Input } from "@angular/core";
import { PostModel } from "../post-response";
import { faArrowUp, faArrowDown } from "@fortawesome/free-solid-svg-icons";
import { VotePayload } from "./vote-payload";
import { VoteType } from "./vote-type";
import { VoteService } from "../vote.service";
import { AuthService } from "src/app/auth/shared/auth.service";
import { PostService } from "../post.service";
import { throwError } from "rxjs";
import { ToastrService } from "ngx-toastr";

@Component({
  selector: "app-vote-button",
  templateUrl: "./vote-button.component.html",
  styleUrls: ["./vote-button.component.css"],
})
export class VoteButtonComponent implements OnInit {
  @Input() post: PostModel;
  votePayload: VotePayload;
  faArrowUp = faArrowUp;
  faArrowDown = faArrowDown;
  upvoteColor: string;
  downvoteColor: string;
  isLoggedIn: boolean;

  constructor(
    private voteService: VoteService,
    private authService: AuthService,
    private postService: PostService,
    private toastr: ToastrService
  ) {
    this.votePayload = {
      voteType: undefined,
      postId: undefined,
      userName: undefined,
    };
    this.isLoggedIn = this.authService.isLoggedIn();
  }

  ngOnInit(): void {
    if (this.isLoggedIn) {
      this.updateVoteDetails();

      this.downvoteColor = "";
      this.upvoteColor = "";
    }
  }

  upvotePost() {
    this.votePayload.voteType = "UPVOTE";
    if (this.isLoggedIn) this.vote();
    else this.toastr.error("You must Login to vote a post");
  }

  downvotePost() {
    this.votePayload.voteType = "DOWNVOTE";
    if (this.isLoggedIn) this.vote();
    else this.toastr.error("You must Login to vote a post");
  }

  private vote() {
    this.votePayload.postId = this.post.id;
    this.votePayload.userName = this.authService.getUserName();
    console.log(this.votePayload);
    this.voteService.vote(this.votePayload).subscribe(
      () => {
        this.updateVoteDetails();
      },
      (error) => {
        console.log(error);
        this.toastr.error(error.error);
        throwError(error);
      }
    );
  }

  private updateVoteDetails() {
    this.postService.getPost(this.post.id).subscribe((post) => {
      this.post = post;
    });

    this.voteService
      .getVote(this.authService.getUserName())
      .subscribe((votes: VotePayload[]) => {
        votes.forEach((val) => {
          if (this.post.id == val.postId) {
            if (val.voteType === "UPVOTE") {
              // console.log(val.voteType);
              this.upvoteColor = "green";
              this.downvoteColor = "";
            } else if (val.voteType === "DOWNVOTE") {
              this.downvoteColor = "red";
              this.upvoteColor = "";
            }
          }
        });
      });
  }
}
