import { CommonService } from './../common.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-dasboard',
  templateUrl: './dasboard.component.html',
  styleUrls: ['./dasboard.component.css'],
})
export class DasboardComponent implements OnInit {
  constructor(private router: ActivatedRoute, private ser: CommonService) {}
  public a;
  ngOnInit() {
    this.a = this.router.snapshot.fragment.split('=');
    this.a = this.a[1].split('&');
    this.ser.access(this.a[0]);
  }
}
