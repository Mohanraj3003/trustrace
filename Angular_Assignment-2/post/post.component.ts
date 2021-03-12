import { Component, OnInit } from '@angular/core';

import { CommonListService } from "../common-list.service";


@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  constructor(private _post:CommonListService) { }
  ngOnInit(): void {
    console.log('post');

  }
  public returnData;
  add(id,title,status){
      let obj ={
        'userId':id,
        'title':title,
        'completed':status
      }
     this._post.postMethod(obj).subscribe(data =>{
      this.returnData =  data
      console.log(data);
     })
    }

}
