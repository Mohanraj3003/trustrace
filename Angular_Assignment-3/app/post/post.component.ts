import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css'],
})
export class PostComponent implements OnInit {
  constructor(private _post: ServiceService, private _location: Location) {}
  backClicked() {
    this._location.back();
  }
  ngOnInit(): void {}
  public returnData;
  public status;

  onSubmit(val) {
    console.log(val);
    let obj = {
      userId: val.userid,
      title: val.title,
      completed: val.chechbox,
    };
    this._post.postMethod(obj).subscribe((data) => {
      this.returnData = data;
      console.log(this.returnData);
    });
  }
}
