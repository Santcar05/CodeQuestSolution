import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { QuestionForm } from '../../models/QuestionForm';

@Injectable({
  providedIn: 'root',
})
export class QuestionFormService {
  private url = 'http://localhost:8080/api/questionform';

  constructor(private http: HttpClient) {}

  findAll(): Observable<QuestionForm[]> {
    return this.http.get<QuestionForm[]>(this.url);
  }
}
