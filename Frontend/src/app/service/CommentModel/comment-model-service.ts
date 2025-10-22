import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CommentModel } from '../../models/Comment';

@Injectable({
  providedIn: 'root',
})
export class CommentModelService {
  private apiUrl = 'http://localhost:8080/api/commentmodel';
  constructor(private http: HttpClient) {}

  findAll(): Observable<CommentModel[]> {
    return this.http.get<CommentModel[]>(`${this.apiUrl}/all`);
  }

  findById(id: number): Observable<CommentModel> {
    return this.http.get<CommentModel>(`${this.apiUrl}/${id}`);
  }
}
