import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { SubredditModel } from "./subreddit-request";
import { Observable } from "rxjs";
import { SubredditRes } from "./subreddit-response";

@Injectable({
  providedIn: "root",
})
export class SubredditService {
  constructor(private http: HttpClient) {}

  getAllSubreddits(): Observable<Array<SubredditRes>> {
    return this.http.get<Array<SubredditRes>>(
      "http://localhost:8080/api/subreddit"
    );
  }

  getOneSubreddits(name: string): Observable<Array<SubredditRes>> {
    return this.http.get<Array<SubredditRes>>(
      "http://localhost:8080/api/subreddit" + name
    );
  }

  createSubreddit(subredditModel: SubredditModel): Observable<SubredditRes> {
    return this.http.post<SubredditRes>(
      "http://localhost:8080/api/subreddit",
      subredditModel
    );
  }
}
