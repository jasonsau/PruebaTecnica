import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TipoProducto } from '../models';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TipoProductoService {
  httpClient = inject(HttpClient);

  constructor() { }

  getTipoProducto(): Observable<TipoProducto[]> {
    return this.httpClient.get<TipoProducto[]>(`${environment.urlApi}/tipoProducto`);
  }
}
