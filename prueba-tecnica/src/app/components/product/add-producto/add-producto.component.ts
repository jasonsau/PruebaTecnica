import { Component, inject, OnInit, output, Output, signal } from '@angular/core';
import { ReactiveFormsModule, FormsModule, FormGroup, FormControl, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MAT_DIALOG_DATA, MatDialog, MatDialogContent, MatDialogModule, MatDialogRef, MatDialogTitle } from '@angular/material/dialog';
import { MatDividerModule } from '@angular/material/divider';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { ProductService, TipoProductoService } from '../../../services';
import { MessageError, ProductoRequest, TipoProducto } from '../../../models';
import { MatSelectModule } from '@angular/material/select';
import { MatSnackBar } from '@angular/material/snack-bar';
import { catchError, throwError } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-add-producto',
  imports: [MatButtonModule, MatDividerModule, MatIconModule],
  templateUrl: './add-producto.component.html',
  styleUrl: './add-producto.component.css'
})
export class AddProductoComponent {
  readonly dialog = inject(MatDialog);

  updateList = output<void>();
  openDialog() {
    this.dialog.open(AddProductoComponentDialog, {data: {updateList: this.updateList}});
  }

}

@Component({
  selector: 'app-add-task-dialog',
  templateUrl: './add-producto-dialog.component.html',
  imports: [
    MatDialogModule, 
    MatDialogContent, 
    MatDialogTitle, 
    MatFormFieldModule, 
    MatInputModule,
    ReactiveFormsModule,
    MatIconModule,
    MatButtonModule,
    MatProgressSpinnerModule,
    FormsModule,
    MatSelectModule,
    MatInputModule
  ],
})
export class AddProductoComponentDialog implements OnInit{

  dataModal = inject(MAT_DIALOG_DATA);

  readonly dialogRef = inject(MatDialogRef<AddProductoComponentDialog>);
  tiposProductoService = inject(TipoProductoService);
  productoService = inject(ProductService);
  tipoProductos: TipoProducto[] = [];
  loading = signal(false);
  private _snackBar = inject(MatSnackBar);

  productoGroupForm = new FormGroup({
    nombre: new FormControl('', {
      validators: [Validators.required, Validators.maxLength(50)]
    }),
    descripcion: new FormControl('', {
      validators: [Validators.required]
    }),
    precio: new FormControl('', {
      validators: [Validators.required, Validators.min(0)]
    }),
    tipoProducto: new FormControl('', {
      validators: [Validators.required]
    }),
    stock: new FormControl('', {
      validators: [Validators.required, Validators.min(0)]
    })
  });


  constructor() {}

  ngOnInit() {
    this.tiposProductoService.getTipoProducto().subscribe((data) => {
      this.tipoProductos = data;
    });
  }

  handleAddProducto() {
    if(this.productoGroupForm.invalid) {
      return;
    }
    const newProducto: ProductoRequest = {
      nombre: this.productoGroupForm.value.nombre || '',
      descripcion: this.productoGroupForm.value.descripcion || '',
      precio: Number.parseInt(this.productoGroupForm.value.precio || '0'),
      idTipoProducto: Number.parseInt(this.productoGroupForm.value.tipoProducto || '0'),
      stock: Number.parseInt(this.productoGroupForm.value.stock || '0') 
    }
    this.productoService.saveProducto(newProducto)
    .pipe(catchError((error: HttpErrorResponse) => {
      if(error.status === 400) {
        const messageError = error.error as MessageError;
        if(messageError.body.codigo === "400") {
          this.openSnackBar(messageError.body.mensaje, 'Cerrar');
        }
      }
      return throwError(() => error);
    }))
    .subscribe((_data) => {
      this.openSnackBar('Producto creado correctamente', 'Cerrar');
      this.productoService.getProducts();
      this.productoGroupForm.reset();
      this.loading.set(false);
      this.dialogRef.close();
      this.dataModal.updateList.emit();
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