import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IntroComponent } from './intro/intro.component';
import { DasboardComponent } from './dasboard/dasboard.component';
import { SearchComponent } from './search/search.component';
import { FormsModule } from '@angular/forms';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { PlaylistComponent } from './playlist/playlist.component';
import { PlayListCreateComponent } from './play-list-create/play-list-create.component';
import { PlayListReadComponent } from './play-list-read/play-list-read.component';
import { PlayListUpdateComponent } from './play-list-update/play-list-update.component';
import { PlayListDeleteComponent } from './play-list-delete/play-list-delete.component';

@NgModule({
  declarations: [
    AppComponent,
    IntroComponent,
    DasboardComponent,
    SearchComponent,
    UserProfileComponent,
    PlaylistComponent,
    PlayListCreateComponent,
    PlayListReadComponent,
    PlayListUpdateComponent,
    PlayListDeleteComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}

/*
Client ID 8aac5220e40b426b92caf64a3ef753f8
Client Secret a31af9df1ea342d2a39554e18dda3d77
*/
