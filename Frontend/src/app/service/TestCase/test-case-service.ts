import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TestCase } from '../../models/TestCase';
@Injectable({
  providedIn: 'root',
})
export class TestCaseService {
  private apiUrl = 'http://localhost:8080/api/testCase';
  constructor(private http: HttpClient) {}
  findAll(): Observable<TestCase[]> {
    return this.http.get<TestCase[]>(this.apiUrl);
  }

  findById(id: number): Observable<TestCase> {
    return this.http.get<TestCase>(`${this.apiUrl}/${id}`);
  }
}
