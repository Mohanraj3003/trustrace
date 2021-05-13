import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ApiServicesService } from '../api-services.service';
import { Result } from './result-response';
// import { Chart } from 'chart.js';
import Chart from 'chart.js/auto';

import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-search-by-countries',
  templateUrl: './search-by-countries.component.html',
  styleUrls: ['./search-by-countries.component.css'],
})
export class SearchByCountriesComponent implements OnInit {
  response: Result[];
  myChart: any;
  @ViewChild('myChart')
  input!: ElementRef;

  label: string[] = [''];
  Confirmed: number[] = [];
  Deaths: number[] = [];
  Active: number[] = [];
  Recovered: number[] = [];

  forms: FormGroup;

  RecoverCheckBox: boolean;
  DeathCheckBox: boolean;
  ConfirmCheckBox: boolean;
  ActiveCheckBox: boolean;

  constructor(private service: ApiServicesService) {
    this.forms = new FormGroup({
      recover: new FormControl(''),
      death: new FormControl(''),
      confirm: new FormControl(''),
      active: new FormControl(''),
    });
  }

  ngOnInit(): void {}

  search(val) {
    this.service.getByCountry(val).subscribe((data: any) => {
      this.response = data;
      this.map();
    });
    this.ActiveCheckBox = this.forms.get('active').value;
    this.DeathCheckBox = this.forms.get('death').value;
    this.ConfirmCheckBox = this.forms.get('confirm').value;
    this.RecoverCheckBox = this.forms.get('recover').value;
  }

  map() {
    this.response.forEach((element: any, index: any) => {
      if (element.Date) {
        this.label[index] = element.Date.substring(0, 10);
      }
      if (element.Confirmed) {
        this.Confirmed[index] = element.Confirmed;
      }
      if (element.Deaths) {
        this.Deaths[index] = element.Deaths;
      }
      if (element.Active) {
        this.Active[index] = element.Active;
      }
      if (element.Recovered) {
        this.Recovered[index] = element.Recovered;
      }
    });

    let confirm = {
      label: 'Confirmed',
      backgroundColor: 'rgb(227, 176, 36)',
      borderColor: 'rgb(227, 176, 36)',
      data: this.Confirmed,
    };

    let death = {
      label: 'Deaths',
      backgroundColor: 'rgb(1, 1, 1)',
      borderColor: 'rgb(1, 1, 1)',
      data: this.Deaths,
    };
    let active = {
      label: 'Active',
      backgroundColor: 'rgb(255, 0, 0)',
      borderColor: 'rgb(255, 107, 114)',
      data: this.Active,
    };
    let recover = {
      label: 'Recovered',
      backgroundColor: 'rgb(48, 128, 5)',
      borderColor: 'rgb(48, 128, 5)',
      data: this.Recovered,
    };

    let show = [];
    if (this.ActiveCheckBox) show.push(active);
    if (this.ConfirmCheckBox) show.push(confirm);
    if (this.DeathCheckBox) show.push(death);
    if (this.RecoverCheckBox) show.push(recover);

    const labels = this.label;
    const data = {
      labels: labels,
      datasets: show,
    };
    if (this.myChart != undefined) this.myChart.destroy();

    this.myChart = new Chart(this.input.nativeElement, {
      type: 'line',
      data,
      options: {},
    });
  }
}
