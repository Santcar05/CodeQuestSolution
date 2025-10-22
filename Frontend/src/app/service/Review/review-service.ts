import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Review } from '../../models/Review';

@Injectable({
  providedIn: 'root',
})
export class ReviewService {
  private apiUrl = 'http://localhost:8080/api/review';
  constructor(private http: HttpClient) {}
  findAll(): Observable<Review[]> {
    return this.http.get<Review[]>(this.apiUrl);
  }

  findById(id: number): Observable<Review> {
    return this.http.get<Review>(`${this.apiUrl}/${id}`);
  }
}
