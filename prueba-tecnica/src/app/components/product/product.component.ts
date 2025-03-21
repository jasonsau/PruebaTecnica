import { Component } from '@angular/core';
import { ListComponent } from './list/list.component';

@Component({
  selector: 'app-product',
  imports: [ListComponent],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent {

}
