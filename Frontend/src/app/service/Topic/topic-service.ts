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

  findByModuleId(moduleId: number): Observable<Topic[]> {
    return this.http.get<Topic[]>(`${this.apiUrl}/module/${moduleId}`);
  }

  save(topic: Topic, idModule: number): Observable<Topic> {
    return this.http.post<Topic>(`${this.apiUrl}/save/${idModule}`, topic);
  }

  update(topic: Topic): Observable<Topic> {
    return this.http.put<Topic>(`${this.apiUrl}/update/${topic.id}`, topic);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`);
  }
}
