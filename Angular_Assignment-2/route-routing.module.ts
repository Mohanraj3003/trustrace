import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PostComponent } from './post/post.component';
import { GetComponent } from './get/get.component';
import { TwowayComponent } from './twoway/twoway.component';
import {ParamsComponent} from './params/params.component';
import {AppComponent} from './app.component';
const routes: Routes = [
  {path:'two',component:TwowayComponent},
  {path:'post',component:PostComponent},
  {path:'get',component:GetComponent},
  {path:'post/:id',component:ParamsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const rountingComponents = [PostComponent,GetComponent,TwowayComponent,ParamsComponent];