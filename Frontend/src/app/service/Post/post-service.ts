import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Post } from '../../models/Post';
@Injectable({
  providedIn: 'root',
})
export class PostService {
  private apiUrl = 'http://localhost:8080/api/post';
  constructor(private http: HttpClient) {}
  findAll(): Observable<Post[]> {
    return this.http.get<Post[]>(this.apiUrl);
  }

  findById(id: number): Observable<Post> {
    return this.http.get<Post>(`${this.apiUrl}/${id}`);
  }
}
