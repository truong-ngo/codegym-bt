import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { map } from "rxjs/operators";
import {Post} from "./post.model";
import {PostService} from "./post.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'httpRequest';

  loadedPosts: Post[] | null = [];
  id: number | undefined;
  isFetching = false;
  error = null;

  constructor(private http: HttpClient, private postService: PostService) {}

  ngOnInit() {
    this.onFetchPosts();
  }

  onCreatePost(postData: Post) {
    // Send Http request
    this.postService.createPost(postData, this.id).subscribe(
      () => {
        this.onFetchPosts()
      }, error => {
        this.error = error.error.error;
      }
    )
  }

  onFetchPosts() {
    // Send Http request
    this.isFetching = true;
    this.postService.fetchPosts().subscribe(
      (response) => {
        this.isFetching = false;
        this.loadedPosts = response;
        if (this.loadedPosts === null) {
          this.id = 1
        } else {
          let length = this.loadedPosts.length
          let lastPost: Post = this.loadedPosts[length - 1]
          // @ts-ignore
          this.id = lastPost.id + 1
        }
        console.log(this.loadedPosts)
        console.log(this.id)
      })
  }

  onClearPosts() {
    this.postService.deletePosts().subscribe(
      () => {
        this.loadedPosts = []
      }
    )
  }
}
