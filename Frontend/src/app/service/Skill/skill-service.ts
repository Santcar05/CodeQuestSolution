import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Skill } from '../../models/Skill';

@Injectable({
  providedIn: 'root',
})
export class SkillService {
  private apiUrl = 'http://localhost:8080/api/skill';
  constructor(private http: HttpClient) {}
  findAll(): Observable<Skill[]> {
    return this.http.get<Skill[]>(`${this.apiUrl}/all`);
  }
  findById(id: number): Observable<Skill> {
    return this.http.get<Skill>(`${this.apiUrl}/${id}`);
  }

  save(skill: Skill): Observable<Skill> {
    return this.http.post<Skill>(`${this.apiUrl}/save`, skill);
  }

  update(skill: Skill): Observable<Skill> {
    return this.http.put<Skill>(`${this.apiUrl}/update`, skill);
  }

  delete(id: number): Observable<Skill> {
    return this.http.delete<Skill>(`${this.apiUrl}/delete/${id}`);
  }
}
