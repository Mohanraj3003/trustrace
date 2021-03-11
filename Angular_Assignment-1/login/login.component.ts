  import { Component, OnInit ,Input, Output , EventEmitter} from '@angular/core';

  @Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
  })
  export class LoginComponent implements OnInit {

    constructor() { }
    
    @Input() username:string;
    @Input() password:string;


    @Output() returnval = new EventEmitter<string>();

    ngOnInit(): void {
      // console.log(this.password);
    }

    validate(user,pass){

      if(this.username === user && this.password === pass)
      {
        this.returnval.emit('true');
      } else{
        this.returnval.emit('false');
      }
    }
  }
