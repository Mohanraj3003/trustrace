import { Component, OnInit } from '@angular/core';

import { ActivatedRoute } from "@angular/router";

import { CommonListService } from "../common-list.service";

@Component({
  selector: 'app-params',
  template: `
  <div *ngIf='params != undefined'>
  <div><strong>id:</strong><h3>{{params.id}}</h3></div>
     <div><strong>UserId:</strong><h3>{{params.userId}}</h3></div>
     
     <div><strong>title:</strong> <h3>{{params.title}}</h3></div>  
     <div><strong>completed:</strong>  <h3>{{params.completed}}</h3></div>  

  </div>
  `,
  styles: [
    'h3{ color: rgb(175, 75, 212); display:inline}','div{margin:20px}','strong{margin:10px ; color: rgb(19, 199, 180)}'
  ]
})
export class ParamsComponent implements OnInit {

  constructor(private router: ActivatedRoute,private _post:CommonListService) { }

  public params;
  ngOnInit(): void {
    console.log('params');
    let id  = parseInt(this.router.snapshot.paramMap.get('id'));
      this._post.getParams(id).subscribe(data => this.params = data )
  }

}
