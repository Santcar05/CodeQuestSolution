import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Topic } from '../../models/Topic';
@Injectable({
  providedIn: 'root',
})
export class TopicService {
  private apiUrl = 'http://localhost:8080/api/topic';
  constructor(private http: HttpClient) {}

  findAll(): Observable<Topic[]> {
    return this.http.get<Topic[]>(this.apiUrl);
  }

  findById(id: number): Observable<Topic> {
    return this.http.get<Topic>(`${this.apiUrl}/${id}`);
  }
}
