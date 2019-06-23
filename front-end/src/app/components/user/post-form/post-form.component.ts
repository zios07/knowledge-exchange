import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-post-form',
  templateUrl: './post-form.component.html',
  styleUrls: ['./post-form.component.scss']
})
export class PostFormComponent implements OnInit {

  title = 'Post form';
  form: FormGroup;
  submitted = false;

  constructor(
    private formBuilder: FormBuilder,
    private postService: PostService,
    private toastr: ToastrService) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
      title: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(64)])],
      content: ['', Validators.compose([Validators.required])],
      category: ['', Validators.compose([Validators.required])]
    });
  }

  onSubmit() {
    let post = this.form.value;
    this.postService.createPost(post).subscribe(resp => {
      this.toastr.info('Post saved with success');
    }, error => {
      this.toastr.error('Error saving the post');
    })
  }

}
