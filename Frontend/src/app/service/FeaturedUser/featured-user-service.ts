import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FeaturedUser } from '../../models/FeaturedUser';

@Injectable({
  providedIn: 'root',
})
export class FeaturedUserService {
  private apiUrl = 'http://localhost:8080/api/featuredUser';
  constructor(private http: HttpClient) {}

  findAll(): Observable<FeaturedUser[]> {
    return this.http.get<FeaturedUser[]>(this.apiUrl);
  }
  findById(id: number): Observable<FeaturedUser> {
    return this.http.get<FeaturedUser>(`${this.apiUrl}/${id}`);
  }
}
