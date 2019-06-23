import { Component, OnInit } from '@angular/core';
import { PostService } from 'src/app/services/post.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.scss']
})
export class PostListComponent implements OnInit {

  posts;

  constructor(
    private postService: PostService,
    private toastr: ToastrService) { }

  ngOnInit() {
    this.loadPosts();
  }

  loadPosts() {
    this.postService.loadPosts().subscribe(resp => {
      this.posts = resp;
    })
  }

}
