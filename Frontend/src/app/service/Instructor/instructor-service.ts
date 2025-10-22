import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Instructor } from '../../models/Instructor';
@Injectable({
  providedIn: 'root',
})
export class InstructorService {
  private apiUrl = 'http://localhost:8080/api/instructor';
  constructor(private http: HttpClient) {}
  findAll(): Observable<Instructor[]> {
    return this.http.get<Instructor[]>(this.apiUrl);
  }

  findById(id: number): Observable<Instructor> {
    return this.http.get<Instructor>(`${this.apiUrl}/${id}`);
  }
}
