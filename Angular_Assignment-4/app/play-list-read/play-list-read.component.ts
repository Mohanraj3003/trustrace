import { CommonService } from './../common.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-play-list-read',
  templateUrl: './play-list-read.component.html',
  styles: [],
})
export class PlayListReadComponent implements OnInit {
  constructor(private ser: CommonService) {}

  public userId;
  public result;
  ngOnInit(): void {}
  user() {
    this.ser.getPlayList(this.userId).subscribe((data) => {
      this.result = data;
      console.log(this.result);
    });
  }
}
