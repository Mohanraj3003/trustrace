import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ServiceService {
  constructor(private http: HttpClient) {}

  // private _subject = new Subject();
  // asObservable$ = this._subject.asObservable();

  public url = 'https://jsonplaceholder.typicode.com/todos';
  getMethod() {
    return this.http.get(this.url);
  }

  putMethod(obj) {
    return this.http.put(this.url, obj);
  }

  getById(id) {
    return this.http.get(`${this.url}/${id}`);
  }

  postMethod(obj) {
    return this.http.post(this.url, obj);
  }
}
