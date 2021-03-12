import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-twoway',
  template: `
    <h4>Input:</h4>
    <input [(ngModel)]="name"  type="text"><br>
    <h4>{{name}}</h4>
    `,
  styles: [
    'h4{font-size:large}','input{margin-bottom: 10px;height: 30px}'
  ]
})
export class TwowayComponent implements OnInit {

  constructor() { }

  public name='';

  ngOnInit(): void {
    console.log('twoway');
  }

}
