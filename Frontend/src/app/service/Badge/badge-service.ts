import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Badge } from '../../models/Badge';

@Injectable({
  providedIn: 'root',
})
export class BadgeService {
  private apiUrl = 'http://localhost:8080/api/badge';
  constructor(private http: HttpClient) {}

  findAll(): Observable<Badge[]> {
    return this.http.get<Badge[]>(`${this.apiUrl}/all`);
  }

  findById(id: number): Observable<Badge> {
    return this.http.get<Badge>(`${this.apiUrl}/${id}`);
  }

  save(badge: Badge): Observable<Badge> {
    return this.http.post<Badge>(this.apiUrl, badge);
  }
}
