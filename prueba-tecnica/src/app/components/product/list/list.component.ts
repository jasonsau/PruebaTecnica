import { Component, inject, OnInit } from '@angular/core';
import { ProductService } from '../../../services/product.service';
import { MatTableModule } from '@angular/material/table';
import { Producto } from '../../../models';

@Component({
  selector: 'app-list',
  imports: [MatTableModule],
  templateUrl: './list.component.html',
  styleUrl: './list.component.css'
})
export class ListComponent implements OnInit{
  productoService = inject(ProductService);
  dataSource: Producto[] = [];
  displayedColumns: string[] = ['nombre', 'descripcion', 'precio', 'tipoProducto', 'stock', 'acciones'];

  ngOnInit() {
    this.productoService.getProducts().subscribe((productos) => {
      this.dataSource = productos;
    });
  }

}
