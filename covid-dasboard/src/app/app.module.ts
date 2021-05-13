import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SearchByCountriesComponent } from './search-by-countries/search-by-countries.component';
import { DasboardComponent } from './dasboard/dasboard.component';
import { ByDateComponent } from './by-date/by-date.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchByCountriesComponent,
    DasboardComponent,
    ByDateComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
