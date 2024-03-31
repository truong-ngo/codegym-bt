import {Injectable} from "@angular/core";
import {Post} from "./post.model";
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";

@Injectable()
export class PostService {

  constructor(private http: HttpClient) {
  }

  createPost(postData: Post, id: number | undefined) {
    postData.id = id;
    return this.http.post(
      'https://angular-demo-5f919-default-rtdb.firebaseio.com/posts.json', postData
    )
  }

  fetchPosts() {
    return this.http.get<Post[]>('https://angular-demo-5f919-default-rtdb.firebaseio.com/posts.json').pipe(
      map(res => {
        if (res !== null) {
          return Object.values(res)
        }
        return null
      })
    )
  }

  deletePosts() {
    return this.http.delete('https://angular-demo-5f919-default-rtdb.firebaseio.com/posts.json')
  }
}
