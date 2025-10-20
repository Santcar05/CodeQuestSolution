import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { OptionForm } from '../../models/OptionForm';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class OptionFormService {
  private url = 'http://localhost:8080/api/optionform';

  constructor(private http: HttpClient) {}

  findAll(): Observable<OptionForm[]> {
    return this.http.get<OptionForm[]>(this.url);
  }

  findByQuestionId(questionId: number): Observable<OptionForm[]> {
    return this.http.get<OptionForm[]>(`${this.url}/question/${questionId}`);
  }
}
