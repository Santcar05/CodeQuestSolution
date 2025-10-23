import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ChatMessage } from '../../models/ChatMessage';

@Injectable({
  providedIn: 'root',
})
export class ChatMessageService {
  private apiUrl = 'http://localhost:8080/api/chatMessages';
  constructor(private http: HttpClient) {}

  findAll(): Observable<ChatMessage[]> {
    return this.http.get<ChatMessage[]>(`${this.apiUrl}/all`);
  }

  findById(id: number): Observable<ChatMessage> {
    return this.http.get<ChatMessage>(`${this.apiUrl}/${id}`);
  }
}
