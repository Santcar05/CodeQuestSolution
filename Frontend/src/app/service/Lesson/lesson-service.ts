import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Lesson } from '../../models/Lesson';

@Injectable({
  providedIn: 'root',
})
export class LessonService {
  private apiUrl = 'http://localhost:8080/api/lesson';
  constructor(private http: HttpClient) {}

  findAll(): Observable<Lesson[]> {
    return this.http.get<Lesson[]>(this.apiUrl);
  }

  findById(id: number): Observable<Lesson> {
    return this.http.get<Lesson>(`${this.apiUrl}/${id}`);
  }

  findByTopicId(id: number): Observable<Lesson[]> {
    return this.http.get<Lesson[]>(`${this.apiUrl}/topic/${id}`);
  }

  save(lesson: Lesson, topicId: number): Observable<Lesson> {
    return this.http.post<Lesson>(`${this.apiUrl}/save/${topicId}`, lesson);
  }

  update(lesson: Lesson): Observable<Lesson> {
    return this.http.put<Lesson>(`${this.apiUrl}/update/${lesson.id}`, lesson);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`);
  }
}
