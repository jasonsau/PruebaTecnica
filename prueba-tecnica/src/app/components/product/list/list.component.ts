import { Component, inject, input, OnDestroy, OnInit, output } from '@angular/core';
import { ProductService } from '../../../services/product.service';
import { MatTableModule } from '@angular/material/table';
import { Producto } from '../../../models';
import { AddProductoComponent } from "../add-producto/add-producto.component";
import { DeleteProductComponent } from "../delete-product/delete-product.component";
import { CurrencyPipe } from '@angular/common';

@Component({
  selector: 'app-list',
  imports: [MatTableModule, AddProductoComponent, DeleteProductComponent, CurrencyPipe],
  templateUrl: './list.component.html',
  styleUrl: './list.component.css'
})
export class ListComponent{
  updateList = output<void>();
  productoService = inject(ProductService);
  displayedColumns: string[] = ['nombre', 'descripcion', 'precio', 'tipoProducto', 'stock', 'acciones'];
  dataSource= input<Producto[]>([]);
  getProducts() {
    this.updateList.emit();
  }
}
