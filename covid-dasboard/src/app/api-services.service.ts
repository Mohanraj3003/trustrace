import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class ApiServicesService {
  constructor(private http: HttpClient) {}

  getByCountry(country: string) {
    return this.http.get(
      `https://api.covid19api.com/total/dayone/country/${country}`
    );
  }

  getByDate(country: string, from: string, to: string) {
    return this.http.get(
      `https://api.covid19api.com/country/${country}?from=${from}&to=${to}`
    );
  }
}
