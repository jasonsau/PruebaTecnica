import { Component, inject, OnInit } from '@angular/core';
import { ListComponent } from './list/list.component';
import { AddProductoComponent } from "./add-producto/add-producto.component";
import { ProductService } from '../../services';
import { Producto } from '../../models';

@Component({
  selector: 'app-product',
  imports: [ListComponent, AddProductoComponent],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent implements OnInit{

  productoService = inject(ProductService);
  dataSource: Producto[] = [];


  ngOnInit() {
    this.getProducts();
  }

  getProducts() {
    console.log('getProducts');
    this.productoService.getProducts().subscribe((productos) => {
      this.dataSource = productos;
    });
  }
}
