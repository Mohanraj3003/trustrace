import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable} from 'rxjs';

import { Posts} from "./post";
@Injectable({
  providedIn: 'root'
})
export class CommonListService {

  constructor(private http: HttpClient) { }

  getMethod(): Observable<Posts[]>{
    return this.http.get<Posts[]>('https://jsonplaceholder.typicode.com/todos')
  }

  postMethod(obj){
     return  this.http.post('https://jsonplaceholder.typicode.com/todos',obj)

  }

  getParams(id){
    return this.http.get(`https://jsonplaceholder.typicode.com/todos/${id}`)
  }
}
