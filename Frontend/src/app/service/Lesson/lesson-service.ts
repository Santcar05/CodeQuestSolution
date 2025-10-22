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
}
