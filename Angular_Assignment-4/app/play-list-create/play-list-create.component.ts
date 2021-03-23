import { CommonService } from './../common.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-play-list-create',
  templateUrl: './play-list-create.component.html',
  styleUrls: ['./play-list-create.component.css'],
})
export class PlayListCreateComponent implements OnInit {
  constructor(private ser: CommonService) {}

  public result;
  public id = this.ser.userId;
  ngOnInit(): void {}

  public body = {
    name: '',
    description: '',
    public: 'public',
  };
  userclick(val) {
    let obj = {
      name: val.name,
      description: val.description,
      public: true,
    };
    this.ser.createPlayList(obj).subscribe((data) => {
      this.result = data;
      // console.log(this.result);
    });
  }
}
