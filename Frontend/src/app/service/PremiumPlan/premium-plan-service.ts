import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PremiumPlan } from '../../models/PremiumPlan';
@Injectable({
  providedIn: 'root',
})
export class PremiumPlanService {
  private apiUrl = 'http://localhost:8080/api/premiumPlan';
  constructor(private http: HttpClient) {}
  findAll(): Observable<PremiumPlan[]> {
    return this.http.get<PremiumPlan[]>(this.apiUrl);
  }
  findById(id: number): Observable<PremiumPlan> {
    return this.http.get<PremiumPlan>(`${this.apiUrl}/${id}`);
  }
}
