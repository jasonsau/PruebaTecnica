import { Component, inject, input, OnInit } from '@angular/core';
import { ProductService } from '../../../services/product.service';
import { MatTableModule } from '@angular/material/table';
import { Producto } from '../../../models';

@Component({
  selector: 'app-list',
  imports: [MatTableModule],
  templateUrl: './list.component.html',
  styleUrl: './list.component.css'
})
export class ListComponent {
  productoService = inject(ProductService);
  //dataSource: Producto[] = [];
  displayedColumns: string[] = ['nombre', 'descripcion', 'precio', 'tipoProducto', 'stock', 'acciones'];
  dataSource= input<Producto[]>([]);


  /*ngOnInit() {
    this.productoService.getProducts().subscribe((productos) => {
      this.dataSource = productos;
    });
  }*/

}
