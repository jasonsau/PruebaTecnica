import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { AuthUserRequest, AuthUserResponse } from '../models';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  httpClient = inject(HttpClient);


  login(userRequest: AuthUserRequest): Observable<AuthUserResponse> {
    return this.httpClient.post<AuthUserResponse>(`${environment.urlApi}/auth/login`, userRequest)
  }

  saveToken(token: string, refreshToken: string) {
    localStorage.setItem('token', token);
    localStorage.setItem('refreshToken', refreshToken);
  }

  logout() {
    localStorage.clear();
  }
}
