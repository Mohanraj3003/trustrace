import { CommonService } from './../common.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-play-list-update',
  templateUrl: './play-list-update.component.html',
  styles: [],
})
export class PlayListUpdateComponent implements OnInit {
  constructor(private ser: CommonService) {}

  public getdata;
  public return;
  getuser(val) {
    this.ser.getPlayListById(val).subscribe((data) => {
      console.log(data);
      this.getdata = data;
    });
  }
  userclick(val, id) {
    this.ser.updatePlayList(val, id);
    this.return = 'Updated Sucessfully...!';
  }

  ngOnInit(): void {}
}
