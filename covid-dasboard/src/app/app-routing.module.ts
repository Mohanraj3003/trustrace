import { ByDateComponent } from './by-date/by-date.component';
import { SearchByCountriesComponent } from './search-by-countries/search-by-countries.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DasboardComponent } from './dasboard/dasboard.component';

const routes: Routes = [
  { path: '', component: DasboardComponent },
  { path: 'searchByCountry', component: SearchByCountriesComponent },
  { path: 'byDate', component: ByDateComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
