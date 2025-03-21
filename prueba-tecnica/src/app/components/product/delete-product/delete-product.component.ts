import { Component, inject, input, output } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MAT_DIALOG_DATA, MatDialog, MatDialogActions, MatDialogContent, MatDialogRef } from '@angular/material/dialog';
import { MatDividerModule } from '@angular/material/divider';
import { MatIconModule } from '@angular/material/icon';
import { Producto } from '../../../models';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ProductService } from '../../../services';
import { catchError } from 'rxjs';

@Component({
  selector: 'app-delete-product',
  imports: [MatButtonModule, MatDividerModule, MatIconModule],
  templateUrl: './delete-product.component.html',
  styleUrl: './delete-product.component.css'
})
export class DeleteProductComponent {
  updateList = output<void>();

  producto = input<Producto>();
  readonly dialog = inject(MatDialog);

  openDialog() {
    this.dialog.open(DeleteProductComponentDialog, {data: {producto: this.producto(), updateList: this.updateList}});
  }

}
@Component({
  selector: 'app-delete-task-dialog',
  templateUrl: './delete-product-dialog.component.html',
  imports: [MatButtonModule, MatDividerModule, MatIconModule, MatDialogContent, MatDialogActions],
})
export class DeleteProductComponentDialog {
  private _snackBar = inject(MatSnackBar);
  readonly dialogRef = inject(MatDialogRef<DeleteProductComponentDialog>);
  producto = inject(MAT_DIALOG_DATA);
  productService = inject(ProductService);

  closeDialog() {
    this.dialogRef.close();
  }

  deleteProduct() {
    this.productService.deleteProducto(this.producto.producto.id)
    .pipe(catchError((error) => {
      this.openSnackBar('Error al eliminar el producto', 'Cerrar');
      return error;
    }))
    .subscribe(() => {
      this.openSnackBar('Producto eliminado', 'Cerrar');
      this.producto.updateList.emit();
      this.closeDialog();
    });
  }
  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, {
      duration: 2000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
    });
  }

}
