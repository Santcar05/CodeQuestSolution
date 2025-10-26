import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LessonContent } from '../../models/LessonContent';
@Injectable({
  providedIn: 'root',
})
export class LessonContentService {
  private apiUrl = 'http://localhost:8080/api/lessoncontent';
  constructor(private http: HttpClient) {}
  findAll(): Observable<LessonContent[]> {
    return this.http.get<LessonContent[]>(this.apiUrl);
  }

  findById(id: number): Observable<LessonContent> {
    return this.http.get<LessonContent>(`${this.apiUrl}/${id}`);
  }

  save(lessonContent: LessonContent): Observable<LessonContent> {
    return this.http.post<LessonContent>(`${this.apiUrl}/save`, lessonContent);
  }

  update(lessonContent: LessonContent): Observable<LessonContent> {
    return this.http.put<LessonContent>(`${this.apiUrl}/update`, lessonContent);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`);
  }
}
