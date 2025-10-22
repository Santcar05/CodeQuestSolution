import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MenuItem } from '../../models/MenuItem';
@Injectable({
  providedIn: 'root',
})
export class MenuItemService {
  private apiUrl = 'http://localhost:8080/api/menuItem';
  constructor(private http: HttpClient) {}
  findAll(): Observable<MenuItem[]> {
    return this.http.get<MenuItem[]>(this.apiUrl);
  }

  findById(id: number): Observable<MenuItem> {
    return this.http.get<MenuItem>(`${this.apiUrl}/${id}`);
  }
}
