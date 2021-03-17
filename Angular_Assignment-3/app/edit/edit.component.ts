import { ActivatedRoute } from '@angular/router';
import { ServiceService } from './../service.service';
import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css'],
})
export class EditComponent implements OnInit {
  public edits;
  constructor(
    private ser: ServiceService,
    private _location: Location,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    let id = this.route.snapshot.paramMap.get('id');
    this.ser.getById(id).subscribe((data) => {
      this.edits = data;
      console.log(this.edits);
    });
  }
  public newdata;
  onSubmit(val) {
    this.newdata = val;
  }
  backClicked() {
    this._location.back();
  }
}
