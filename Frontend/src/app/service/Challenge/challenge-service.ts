import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Challenge } from '../../models/Challenge';

@Injectable({
  providedIn: 'root',
})
export class ChallengeService {
  private apiUrl = 'http://localhost:8080/api/challenge';
  constructor(private http: HttpClient) {}

  findAll(): Observable<Challenge[]> {
    return this.http.get<Challenge[]>(`${this.apiUrl}/all`);
  }

  findById(id: number): Observable<Challenge> {
    return this.http.get<Challenge>(`${this.apiUrl}/${id}`);
  }
}
