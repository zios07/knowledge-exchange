import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Message } from 'src/app/models/Message';
import { MessageService } from 'src/app/services/message.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-inbox',
  templateUrl: './inbox.component.html',
  styleUrls: ['./inbox.component.scss']
})
export class InboxComponent implements OnInit {


  response: Message = new Message();
  messages: Message[] = [];
  responding: boolean = false;
  selectedMessage: Message = new Message();

  constructor(
    private messageService: MessageService,
    private userService: UserService,
    private toastr: ToastrService
  ) { }

  ngOnInit() {
    this.loadMessages();
  }

  respond(msg) {
    this.selectedMessage = msg;
    this.responding = true;
  }

  send() {
    this.response.sendDate = new Date();
    this.response.parentMessage = this.selectedMessage;
    this.response.receiver = this.selectedMessage.sender;
    this.response.sender = this.selectedMessage.receiver;
    this.response.subject = this.selectedMessage.subject;
    this.messageService.send(this.response).subscribe(message => {
      this.loadMessages();
      this.toastr.info('You message was sent to : ' + this.response.receiver.account.username);
      this.responding = false;
      this.response = new Message();
    });
  }

  loadMessages() {
    this.userService.getAuthenticatedUser().subscribe((user: any) => {
      this.messageService.loadForReceiver(user.id).subscribe((messages: any) => {
        this.messages = messages;
      });
    });
  }

}
