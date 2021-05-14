import { Component, OnInit, ViewEncapsulation, Input } from "@angular/core";
// import { PostService } from "../post.service";
import { faComments } from "@fortawesome/free-solid-svg-icons";
import { Router } from "@angular/router";
import { PostModel } from "../post-response";

@Component({
  selector: "app-post-tile",
  templateUrl: "./post-tile.component.html",
  styleUrls: ["./post-tile.component.css"],
  encapsulation: ViewEncapsulation.None,
})
export class PostTileComponent implements OnInit {
  faComments = faComments;
  @Input() posts: PostModel[];

  constructor(private router: Router) {}

  ngOnInit(): void {}

  goToPost(id: string): void {
    this.router.navigateByUrl("/view-post/" + id);
  }
}
