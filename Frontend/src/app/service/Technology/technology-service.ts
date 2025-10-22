import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Technology } from '../../models/Technology';
@Injectable({
  providedIn: 'root',
})
export class TechnologyService {
  private apiUrl = 'http://localhost:8080/api/technology';
  constructor(private http: HttpClient) {}
  findAll(): Observable<Technology[]> {
    return this.http.get<Technology[]>(this.apiUrl);
  }
  findById(id: number): Observable<Technology> {
    return this.http.get<Technology>(`${this.apiUrl}/${id}`);
  }
}
