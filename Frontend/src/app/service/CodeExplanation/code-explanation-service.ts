import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CodeExplanation } from '../../models/CodeExplanation';
@Injectable({
  providedIn: 'root',
})
export class CodeExplanationService {
  private apiUrl = 'http://localhost:8080/api/codeExplanation';
  constructor(private http: HttpClient) {}

  findAll(): Observable<CodeExplanation[]> {
    return this.http.get<CodeExplanation[]>(`${this.apiUrl}/all`);
  }

  findById(id: number): Observable<CodeExplanation> {
    return this.http.get<CodeExplanation>(`${this.apiUrl}/${id}`);
  }
}
