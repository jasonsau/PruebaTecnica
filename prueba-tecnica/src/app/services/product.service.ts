import { HttpClient } from '@angular/common/http';
import { computed, inject, Injectable, signal } from '@angular/core';
import { environment } from '../../environments/environment';
import { Producto } from '../models';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  httpClient = inject(HttpClient);
  constructor() { }
  getProducts():Observable<Producto[]> {
    return this.httpClient.get<Producto[]>(`${environment.urlApi}/producto`);
  }
}
