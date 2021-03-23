import { CommonService } from './../common.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
})
export class UserProfileComponent implements OnInit {
  constructor(private ser: CommonService) {}
  public userId;
  public result;
  ngOnInit(): void {}
  user() {
    this.ser.searchUser(this.userId).subscribe((data) => {
      this.result = data;
      // console.log(this.result);
    });
  }
}
