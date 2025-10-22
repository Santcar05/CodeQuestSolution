import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Trend } from '../../models/Trend';

@Injectable({
  providedIn: 'root',
})
export class TrendService {
  private apiUrl = 'http://localhost:8080/api/trend';
  constructor(private http: HttpClient) {}
  findAll(): Observable<Trend[]> {
    return this.http.get<Trend[]>(this.apiUrl);
  }

  findById(id: number): Observable<Trend> {
    return this.http.get<Trend>(`${this.apiUrl}/${id}`);
  }
}
