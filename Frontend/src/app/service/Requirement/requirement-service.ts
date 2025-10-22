import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Requirement } from '../../models/Requirement';

@Injectable({
  providedIn: 'root',
})
export class RequirementService {
  private apiUrl = 'http://localhost:8080/api/requirement';
  constructor(private http: HttpClient) {}
  findAll(): Observable<Requirement[]> {
    return this.http.get<Requirement[]>(this.apiUrl);
  }
  findById(id: number): Observable<Requirement> {
    return this.http.get<Requirement>(`${this.apiUrl}/${id}`);
  }
}
