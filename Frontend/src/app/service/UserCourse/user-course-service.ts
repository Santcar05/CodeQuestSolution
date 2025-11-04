import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserCourse } from '../../models/UserCourse';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class UserCourseService {
  private apiUrl = 'http://localhost:8080/api/usercourse';

  constructor(private http: HttpClient) {}

  findAll(): Observable<UserCourse[]> {
    return this.http.get<UserCourse[]>(`${this.apiUrl}/all`); // ← Corregido
  }

  findById(id: number): Observable<UserCourse> {
    return this.http.get<UserCourse>(`${this.apiUrl}/${id}`);
  }

  findByUserProfileId(userId: number): Observable<UserCourse[]> {
    return this.http.get<UserCourse[]>(`${this.apiUrl}/user/${userId}`);
  }

  findByCourseId(courseId: number): Observable<UserCourse[]> {
    return this.http.get<UserCourse[]>(`${this.apiUrl}/course/${courseId}`);
  }

  // ✅ SOLUCIÓN: Elimina los headers manuales
  save(userCourse: UserCourse): Observable<UserCourse> {
    return this.http.post<UserCourse>(`${this.apiUrl}/save`, userCourse);
  }

  update(userCourse: UserCourse): Observable<UserCourse> {
    return this.http.put<UserCourse>(`${this.apiUrl}/update`, userCourse);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`);
  }
}
