import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Message } from 'src/app/models/Message';
import { MessageService } from 'src/app/services/message.service';
import { PostService } from 'src/app/services/post.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.scss']
})
export class MessageComponent implements OnInit {

  post;
  message: Message = new Message();
  status: string;

  constructor(
    private messageService: MessageService,
    private postService: PostService,
    private userService: UserService,
    private route: ActivatedRoute,
    private toastr: ToastrService
  ) { }

  ngOnInit() {
    this.loadTargetPost();
    this.userService.getAuthenticatedUser().subscribe((resp: any) => {
      this.message.sender = resp;
    });
  }

  sendMessage() {
    this.message.sendDate = new Date();
    this.messageService.send(this.message).subscribe(message => {
      this.toastr.info('Message sent');
      this.status = 'Your message was sent successfully';
    });
  }

  loadTargetPost() {
    const id = this.route.snapshot.paramMap.get('postId');
    if (id) {
      this.postService.getPostById(id).subscribe((result: any) => {
        this.post = result;
        this.message.receiver = result.user;
      }, error => {
        this.toastr.error(String(error));
      });
    }
  }
}
