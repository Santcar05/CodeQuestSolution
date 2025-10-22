import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Power } from '../../models/Power';

@Injectable({
  providedIn: 'root',
})
export class PowerService {
  private apiUrl = 'http://localhost:8080/api/power';
  constructor(private http: HttpClient) {}

  findAll(): Observable<Power[]> {
    return this.http.get<Power[]>(this.apiUrl);
  }

  findById(id: number): Observable<Power> {
    return this.http.get<Power>(`${this.apiUrl}/${id}`);
  }
}
