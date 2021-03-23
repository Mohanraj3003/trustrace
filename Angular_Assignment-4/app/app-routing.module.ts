import { PlayListDeleteComponent } from './play-list-delete/play-list-delete.component';
import { PlayListReadComponent } from './play-list-read/play-list-read.component';
import { PlayListUpdateComponent } from './play-list-update/play-list-update.component';
import { PlayListCreateComponent } from './play-list-create/play-list-create.component';
import { PlaylistComponent } from './playlist/playlist.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { SearchComponent } from './search/search.component';
import { DasboardComponent } from './dasboard/dasboard.component';
import { IntroComponent } from './intro/intro.component';
import { AppComponent } from './app.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'intro', pathMatch: 'full' },
  { path: 'intro', component: IntroComponent },
  { path: 'dasboard', component: DasboardComponent },
  { path: 'search', component: SearchComponent },
  { path: 'userprofile', component: UserProfileComponent },
  {
    path: 'playlist',
    component: PlaylistComponent,
    children: [
      { path: 'create', component: PlayListCreateComponent },
      { path: 'update', component: PlayListUpdateComponent },
      { path: 'read', component: PlayListReadComponent },
      { path: 'delete', component: PlayListDeleteComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
