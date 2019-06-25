import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Message } from '../models/Message';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  url = environment.API_URL + '/messages/';

  constructor(private http: HttpClient) { }

  send(message: Message) {
    return this.http.post(this.url, message);
  }

  loadForReceiver(id: number) {
    return this.http.get(this.url + 'receiver/' + id);
  }

  loadReceivedMessages(id: number) {
    return this.http.get(this.url + id);
  }

  loadSentMessages(id: number) {
    return this.http.get(this.url + id);
  }

}
