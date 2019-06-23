import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  url = environment.API_URL;

  constructor(private http: HttpClient) { }

  createPost(post) {
    return this.http.post(this.url + '/posts', post);
  }

}
