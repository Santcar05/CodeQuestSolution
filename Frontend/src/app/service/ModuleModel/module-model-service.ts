import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ModuleModel } from '../../models/ModuleModel';
@Injectable({
  providedIn: 'root',
})
export class ModuleModelService {
  private apiUrl = 'http://localhost:8080/api/moduleModel';
  constructor(private http: HttpClient) {}
  findAll(): Observable<ModuleModel[]> {
    return this.http.get<ModuleModel[]>(this.apiUrl);
  }

  findById(id: number): Observable<ModuleModel> {
    return this.http.get<ModuleModel>(`${this.apiUrl}/${id}`);
  }
}
