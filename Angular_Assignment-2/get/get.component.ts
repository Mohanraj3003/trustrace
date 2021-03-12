import { Component, OnInit } from '@angular/core';

import { CommonListService } from "../common-list.service";
@Component({
  selector: 'app-get',
  templateUrl: './get.component.html',
  styleUrls: ['./get.component.css']
})
export class GetComponent implements OnInit {

  public list
  constructor(private _post:CommonListService) { }

  ngOnInit(): void {
    console.log('get');
    this._post.getMethod().subscribe(data => this.list = data)
  }

}
