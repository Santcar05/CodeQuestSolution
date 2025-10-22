/*
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root',
})

export class ExamDetailService {
  private apiUrl = 'http://localhost:8080/api/examDetail';
  constructor(private http: HttpClient) {}
  findAll(): Observable<ExamDetail[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
  findById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }
}
*/
