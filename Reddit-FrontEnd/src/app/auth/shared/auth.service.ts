import { Injectable, Output, EventEmitter } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { SignupRequestPayload } from "../signup/singup-request.payload";
import { Observable, throwError } from "rxjs";
import { LocalStorageService } from "ngx-webstorage";
import { LoginRequestPayload } from "../login/login-request.payload";
import { LoginResponse } from "../login/login-response.payload";
import { map, tap } from "rxjs/operators";

@Injectable({
  providedIn: "root",
})
export class AuthService {
  @Output() loggedIn: EventEmitter<boolean> = new EventEmitter();
  @Output() username: EventEmitter<string> = new EventEmitter();

  constructor(
    private httpClient: HttpClient,
    private localStorage: LocalStorageService
  ) {}

  signup(signupRequestPayload: SignupRequestPayload): Observable<any> {
    return this.httpClient.post(
      "http://localhost:8080/api/auth",
      signupRequestPayload,
      { responseType: "text" }
    );
  }

  login(loginRequestPayload: LoginRequestPayload): Observable<boolean> {
    return this.httpClient
      .post<LoginResponse>(
        "http://localhost:8080/api/auth/login",
        loginRequestPayload
      )
      .pipe(
        map((data) => {
          this.localStorage.store(
            "authenticationToken",
            data.authenticationToken
          );
          this.localStorage.store("userName", data.userName);
          this.loggedIn.emit(true);
          this.username.emit(data.userName);
          return true;
        })
      );
    console.log("after");
  }

  getJwtToken() {
    return this.localStorage.retrieve("authenticationToken");
  }

  logout() {
    this.httpClient
      .post("http://localhost:8080/api/auth/logout", {
        responseType: "text",
      })
      .subscribe(
        (data) => {
          console.log(data);
        },
        (error) => {
          throwError(error);
        }
      );
    this.localStorage.clear("authenticationToken");
    this.localStorage.clear("userName");
  }

  getUserName() {
    return this.localStorage.retrieve("userName");
  }

  isLoggedIn(): boolean {
    return this.getJwtToken() != null;
  }
}
