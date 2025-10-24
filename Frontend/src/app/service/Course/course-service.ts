import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Course } from '../../models/Course';
@Injectable({
  providedIn: 'root',
})
export class CourseService {
  private apiUrl = 'http://localhost:8080/api/course';
  constructor(private http: HttpClient) {}
  findAll(): Observable<Course[]> {
    return this.http.get<Course[]>(`${this.apiUrl}/all`);
  }
  findById(id: number): Observable<Course> {
    return this.http.get<Course>(`${this.apiUrl}/${id}`);
  }

  findWishlist(): Observable<Course[]> {
    return this.http.get<Course[]>(`${this.apiUrl}/wishlist`);
  }

  //obtener actividad semanal
  findWeeklyActivity(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/weekly-activity`);
  }

  save(course: Course): Observable<Course> {
    return this.http.post<Course>(`${this.apiUrl}`, course);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  update(course: Course): Observable<Course> {
    return this.http.put<Course>(`${this.apiUrl}`, course);
  }
}
