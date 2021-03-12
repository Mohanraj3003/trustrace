import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';

import { AppComponent } from './app.component';

import {CommonListService} from './common-list.service';


import { rountingComponents , AppRoutingModule} from "./route-routing.module";

import { HttpClientModule } from '@angular/common/http';
import { ParamsComponent } from './params/params.component';
@NgModule({
  declarations: [
    AppComponent,
    rountingComponents,
    ParamsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [CommonListService],
  bootstrap: [AppComponent]
})
export class AppModule { }
