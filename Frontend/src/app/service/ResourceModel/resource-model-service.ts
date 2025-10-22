import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ResourceModel } from '../../models/Resource';

@Injectable({
  providedIn: 'root',
})
export class ResourceModelService {
  private apiUrl = 'http://localhost:8080/api/resourceModel';
  constructor(private http: HttpClient) {}
  findAll(): Observable<ResourceModel[]> {
    return this.http.get<ResourceModel[]>(this.apiUrl);
  }
  findById(id: number): Observable<ResourceModel> {
    return this.http.get<ResourceModel>(`${this.apiUrl}/${id}`);
  }
}
