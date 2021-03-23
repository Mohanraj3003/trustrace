import { CommonService } from './../common.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-intro',
  templateUrl: './intro.component.html',
  styleUrls: ['./intro.component.css'],
})
export class IntroComponent implements OnInit {
  constructor(private ser: CommonService) {}

  ngOnInit(): void {}

  load() {
    this.ser.onload();
  }
}

// Client ID 8aac5220e40b426b92caf64a3ef753f8
// Client Secret a31af9df1ea342d2a39554e18dda3d77
// http://localhost:4200/?code=AQBIpFnfCc_XYRGGnuVjo06DHca5oXHWUPtM-M1PwdlT3vBkweoUjf_5RKNOfq9Kq1Qb7vSGJ0VQ7wPYSUzF6ZsveQ1f4BumQF-CjWN2LVW8g4lOVsYhmzdE7-g0IwBUam7fpZYZu-sBY0Elb3oCCuO2d1SVYQmH1mQ
