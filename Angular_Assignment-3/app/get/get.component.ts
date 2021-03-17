import { Router } from '@angular/router';
import { Search } from './../search';
import { ServiceService } from './../service.service';
import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
@Component({
  selector: 'app-get',
  templateUrl: './get.component.html',
  styleUrls: ['./get.component.css'],
})
export class GetComponent implements OnInit {
  searchs: Search[];
  searchText = '';
  public put;
  constructor(
    private ser: ServiceService,
    private _location: Location,
    private route: Router
  ) {}

  ngOnInit(): void {
    this.ser.getMethod().subscribe((data: Search[]) => (this.searchs = data));
  }

  backClicked() {
    this._location.back();
  }

  edit(id) {
    // console.log(`${id},${title},${completed},${userId}`);
    this.route.navigate([`/edit/${id}`]);
  }
}
