import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ExamResults } from '../../models/ExamResults';
@Injectable({
  providedIn: 'root',
})
export class ExamResultsService {
  private apiUrl = 'http://localhost:8080/api/examResults';
  constructor(private http: HttpClient) {}
  findAll(): Observable<ExamResults[]> {
    return this.http.get<ExamResults[]>(this.apiUrl);
  }
  findById(id: number): Observable<ExamResults> {
    return this.http.get<ExamResults>(`${this.apiUrl}/${id}`);
  }
}
