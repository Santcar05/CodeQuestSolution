import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ModuleModel } from '../../models/ModuleModel';
@Injectable({
  providedIn: 'root',
})
export class ModuleModelService {
  private apiUrl = 'http://localhost:8080/api/modulemodel';
  constructor(private http: HttpClient) {}
  findAll(): Observable<ModuleModel[]> {
    return this.http.get<ModuleModel[]>(this.apiUrl);
  }

  findById(id: number): Observable<ModuleModel> {
    return this.http.get<ModuleModel>(`${this.apiUrl}/${id}`);
  }

  save(moduleModel: ModuleModel, id: number): Observable<ModuleModel> {
    return this.http.post<ModuleModel>(`${this.apiUrl}/save/${id}`, moduleModel);
  }

  update(moduleModel: ModuleModel): Observable<ModuleModel> {
    return this.http.put<ModuleModel>(`${this.apiUrl}/update/${moduleModel.id}`, moduleModel);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`);
  }

  findByCourseId(id: number): Observable<ModuleModel[]> {
    return this.http.get<ModuleModel[]>(`${this.apiUrl}/course/${id}`);
  }
}
