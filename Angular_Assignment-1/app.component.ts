import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public title = 'my-first-project';

   username:string;
   password:string ;
   result:string;

  ngOnInit(){
    console.log("some txt");
    this.username = 'test';
    this.password = 'pass';
    console.log("username:"+this.username);
    console.log("username:"+this.password);
  }
  displayresult(val){
    console.log(val);
    this.result=val;
  }


  
}
