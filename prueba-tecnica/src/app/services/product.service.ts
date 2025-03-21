import { HttpClient } from '@angular/common/http';
import { computed, inject, Injectable, signal } from '@angular/core';
import { environment } from '../../environments/environment';
import { Producto, ProductoRequest} from '../models';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  httpClient = inject(HttpClient);

  getProducts():Observable<Producto[]> {
    return this.httpClient.get<Producto[]>(`${environment.urlApi}/producto`);
  }

  saveProducto(productoRequest: ProductoRequest): Observable<Producto> {
    return this.httpClient.post<Producto>(`${environment.urlApi}/producto`, productoRequest, {
      headers: {
        'Content-Type': 'application/json'
      }
    });
  }

  updateProducto(productoRequest: ProductoRequest): Observable<Producto> {
    return this.httpClient.put<Producto>(`${environment.urlApi}/producto/${productoRequest.id}`, productoRequest, {
      headers: {
        'Content-Type': 'application/json'
      }
    });
  }
}
