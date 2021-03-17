import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: [],
})
export class LoginComponent implements OnInit {
  constructor(private route: Router) {}

  ngOnInit(): void {}

  onSubmit() {
    this.route.navigate(['/home']);
  }
}
