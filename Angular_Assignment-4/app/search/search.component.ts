import { CommonService } from './../common.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
})
export class SearchComponent implements OnInit {
  constructor(private ser: CommonService) {}
  public search = '';
  public result;
  ngOnInit(): void {}

  searchbtn() {
    let str = this.search.split(' ').join('%20');
    this.ser.searchSong(str).subscribe((data) => {
      this.result = data;
      // console.log(this.result.tracks.items[0]);
      // for (let a of this.result.tracks.items) {
      //   console.log(a);
      // }
    });
  }
}
