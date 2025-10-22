import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LessonContent } from '../../models/LessonContent';
@Injectable({
  providedIn: 'root',
})
export class LessonContentService {
  private apiUrl = 'http://localhost:8080/api/lessonContent';
  constructor(private http: HttpClient) {}
  findAll(): Observable<LessonContent[]> {
    return this.http.get<LessonContent[]>(this.apiUrl);
  }

  findById(id: number): Observable<LessonContent> {
    return this.http.get<LessonContent>(`${this.apiUrl}/${id}`);
  }
}
