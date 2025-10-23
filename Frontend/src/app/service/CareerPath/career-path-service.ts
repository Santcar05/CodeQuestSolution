import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CareerPath } from '../../models/CarrerPath';

@Injectable({
  providedIn: 'root',
})
export class CareerPathService {
  private apiUrl = 'http://localhost:8080/api/careerpath';
  constructor(private http: HttpClient) {}

  findAll(): Observable<CareerPath[]> {
    return this.http.get<CareerPath[]>(`${this.apiUrl}/all`);
  }

  findById(id: number): Observable<CareerPath> {
    return this.http.get<CareerPath>(`${this.apiUrl}/${id}`);
  }
}
