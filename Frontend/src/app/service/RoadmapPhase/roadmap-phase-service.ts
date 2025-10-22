import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RoadmapPhase } from '../../models/RoadMapPhase';

@Injectable({
  providedIn: 'root',
})
export class RoadmapPhaseService {
  private apiUrl = 'http://localhost:8080/api/roadmapPhase';
  constructor(private http: HttpClient) {}
  findAll(): Observable<RoadmapPhase[]> {
    return this.http.get<RoadmapPhase[]>(this.apiUrl);
  }
  findById(id: number): Observable<RoadmapPhase> {
    return this.http.get<RoadmapPhase>(`${this.apiUrl}/${id}`);
  }
}
