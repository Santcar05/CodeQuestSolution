import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RoadmapItem } from '../../models/RoadMapItem';

@Injectable({
  providedIn: 'root',
})
export class RoadmapItemService {
  private apiUrl = 'http://localhost:8080/api/roadmapItem';
  constructor(private http: HttpClient) {}
  findAll(): Observable<RoadmapItem[]> {
    return this.http.get<RoadmapItem[]>(this.apiUrl);
  }

  findById(id: number): Observable<RoadmapItem> {
    return this.http.get<RoadmapItem>(`${this.apiUrl}/${id}`);
  }
}
