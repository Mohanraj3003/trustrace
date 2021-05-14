import { AuthService } from "src/app/auth/shared/auth.service";
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { VotePayload } from "./vote-button/vote-payload";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class VoteService {
  constructor(private http: HttpClient, private authService: AuthService) {}

  vote(votePayload: VotePayload): Observable<any> {
    return this.http.post("http://localhost:8080/api/votes", votePayload);
  }

  getVote(user: string) {
    // console.log(this.req.headers.get("Authorization"));
    return this.http.get("http://localhost:8080/api/votes/" + user);
  }
}
