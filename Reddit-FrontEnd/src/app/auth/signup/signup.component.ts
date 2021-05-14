import { Component, OnInit } from "@angular/core";
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { SignupRequestPayload } from "./singup-request.payload";
import { AuthService } from "../shared/auth.service";
import { ToastrService } from "ngx-toastr";
import { Router } from "@angular/router";

@Component({
  selector: "app-signup",
  templateUrl: "./signup.component.html",
  styleUrls: ["./signup.component.css"],
})
export class SignupComponent implements OnInit {
  signupRequestPayload: SignupRequestPayload;
  signupForm: FormGroup;

  constructor(
    private authService: AuthService,
    private router: Router,
    private toastr: ToastrService
  ) {
    this.signupRequestPayload = {
      name: "",
      userName: "",
      mail: "",
      password: "",
    };
  }

  ngOnInit() {
    this.signupForm = new FormGroup({
      username: new FormControl("", Validators.required),
      name: new FormControl("", Validators.required),
      email: new FormControl("", [Validators.required, Validators.email]),
      password: new FormControl("", Validators.required),
    });
  }

  signup() {
    this.signupRequestPayload.name = this.signupForm.get("name").value;
    this.signupRequestPayload.mail = this.signupForm.get("email").value;
    this.signupRequestPayload.userName = this.signupForm.get("username").value;
    this.signupRequestPayload.password = this.signupForm.get("password").value;

    this.authService.signup(this.signupRequestPayload).subscribe(
      (data) => {
        this.router.navigate(["/login"], {
          queryParams: { registered: "true" },
        });
      },
      (error) => {
        console.log(error);
        this.toastr.error("Registration Failed!  (" + error.error + ")");
      }
    );
  }
}
