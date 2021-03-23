import { CommonService } from './../common.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-play-list-delete',
  templateUrl: './play-list-delete.component.html',
  styles: [],
})
export class PlayListDeleteComponent implements OnInit {
  constructor(private ser: CommonService) {}

  public getdata;
  public result;
  getuser(val) {
    this.ser.getPlayListItems(val).subscribe((data) => {
      console.log(data);
      this.getdata = data;
    });
  }
  del(val, id) {
    let obj = {
      tracks: [
        {
          uri: val,
        },
      ],
    };

    this.ser.deleteTrack(obj, id).subscribe((data) => {
      console.log(data);
    });
  }
  ngOnInit(): void {}
}
