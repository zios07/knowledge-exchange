import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { CommentService } from 'src/app/services/comment.service';
import { PostService } from 'src/app/services/post.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-post-view',
  templateUrl: './post-view.component.html',
  styleUrls: ['./post-view.component.scss']
})
export class PostViewComponent implements OnInit {

  form: FormGroup;
  post;
  loading = false;

  constructor(private formBuilder: FormBuilder, private userService: UserService,
    private route: ActivatedRoute, private postService: PostService, private toastr: ToastrService,
    private commentService: CommentService) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
      comment: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(64)])]
    });
    this.getPostToView();
  }

  getPostToView() {
    this.loading = true;
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.postService.getPostById(id).subscribe((result: any) => {
        this.post = result;
        this.loading = false;
      }, error => {
        this.toastr.error(String(error));
      });
    }
  }

  onSubmit() {
    this.userService.getAuthenticatedUser().subscribe((resp: any) => {
      const comment: any = {};
      comment.content = this.form.get('comment').value;
      comment.date = new Date();
      comment.post = this.post;
      comment.user = resp;
      this.commentService.saveComment(comment).subscribe(() => {
        this.toastr.info('comment sent successfully');
        this.getPostToView();
      });
    });
  }

}
