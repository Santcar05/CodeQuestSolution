import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Achievement } from '../../models/Achievement';

@Injectable({
  providedIn: 'root',
})
export class AchievementService {
  private apiUrl = 'http://localhost:8080/api/achievement';

  constructor(private http: HttpClient) {}

  /**
   * Obtiene todos los logros del backend
   */
  findAll(): Observable<Achievement[]> {
    return this.http.get<Achievement[]>(`${this.apiUrl}/all`);
  }

  /**
   * Guarda un nuevo logro
   * @param achievement logro a guardar
   */
  save(achievement: Achievement): Observable<void> {
    return this.http.post<void>(this.apiUrl, achievement);
  }

  /**
   * Actualiza un logro existente
   * @param achievement logro con los datos actualizados
   */
  update(achievement: Achievement): Observable<void> {
    return this.http.put<void>(this.apiUrl, achievement);
  }

  /**
   * Elimina un logro
   * @param achievement logro a eliminar
   */
  delete(achievement: Achievement): Observable<void> {
    return this.http.delete<void>(this.apiUrl, { body: achievement });
  }
}
