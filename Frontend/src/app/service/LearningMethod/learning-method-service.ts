import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LearningMethod } from '../../models/LearningMethod';
@Injectable({
  providedIn: 'root',
})
export class LearningMethodService {
  private apiUrl = 'http://localhost:8080/api/learningMethod';
  constructor(private http: HttpClient) {}
  findAll(): Observable<LearningMethod[]> {
    return this.http.get<LearningMethod[]>(this.apiUrl);
  }

  findById(id: number): Observable<LearningMethod> {
    return this.http.get<LearningMethod>(`${this.apiUrl}/${id}`);
  }
}
