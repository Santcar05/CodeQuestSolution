import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Question } from '../../models/Question';

@Injectable({
  providedIn: 'root',
})
export class QuestionService {
  private apiUrl = 'http://localhost:8080/api/question';
  constructor(private http: HttpClient) {}
  findAll(): Observable<Question[]> {
    return this.http.get<Question[]>(this.apiUrl);
  }

  findById(id: number): Observable<Question> {
    return this.http.get<Question>(`${this.apiUrl}/${id}`);
  }
}
