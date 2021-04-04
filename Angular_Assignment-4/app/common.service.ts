import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class CommonService {
   client_id ='' // Client id from developers.spotify.com //
  url =
    `https://accounts.spotify.com/authorize?client_id=${client_id}&redirect_uri=http://localhost:4200/dasboard&scope=playlist-modify-public&response_type=token`;
  constructor(
    private http: HttpClient,
    private route: Router // private headres: HttpHeaders
  ) {}

  onload() {
    window.location.href = this.url;
  }

  public access_token = '';
  public userId = 'q6z57l5jt2shs3x3lumv2m1n0';

  access(tk) {
    this.access_token = tk;
  }
  headers() {
    let head = new HttpHeaders()
      .set('Accept', 'application/json')
      .set('Content-Type', 'application/json')
      .set('Authorization', `Bearer ${this.access_token}`);
    return head;
  }
  searchSong(str) {
    return this.http.get(
      `https://api.spotify.com/v1/search?q=${str}&type=track&market=IN`,
      { headers: this.headers() }
    );
  }

  searchUser(user) {
    return this.http.get(`https://api.spotify.com/v1/users/${user}`, {
      headers: this.headers(),
    });
  }

  getPlayList(user) {
    return this.http.get(`https://api.spotify.com/v1/users/${user}/playlists`, {
      headers: this.headers(),
    });
  }
  createPlayList(obj) {
    return this.http.post(
      `https://api.spotify.com/v1/users/${this.userId}/playlists`,
      obj,
      { headers: this.headers() }
    );
  }

  updatePlayList(obj, id) {
    this.http
      .put(`https://api.spotify.com/v1/playlists/${id}`, obj, {
        headers: this.headers(),
      })
      .toPromise()
      // .then((data) => console.log(data))
      .catch((e) => {
        console.log(e.message);
      });
  }

  getPlayListById(playlist_id) {
    return this.http.get(
      `https://api.spotify.com/v1/playlists/${playlist_id}`,
      {
        headers: this.headers(),
      }
    );
  }

  getPlayListItems(id) {
    return this.http.get(`https://api.spotify.com/v1/playlists/${id}/tracks`, {
      headers: this.headers(),
    });
  }

  deleteTrack(obj, id) {
    return this.http.request(
      'delete',
      `https://api.spotify.com/v1/playlists/${id}/tracks`,
      { body: obj, headers: this.headers() }
    );
    // return this.http.delete(
    //   `https://api.spotify.com/v1/playlists/${id}/tracks`,
    //   { headers: this.headers(),observe: obj }
    // );
  }
}
// .toPromise()
//       .then((data) => {
//         console.log(data);
//       })
//       .catch((e) => {
//         console.log(e.message);
//       });
