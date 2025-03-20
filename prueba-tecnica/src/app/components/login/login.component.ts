import { Component, inject } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AuthUserRequest } from '../../models';
import { HttpErrorResponse } from '@angular/common/http';
import { AuthService } from '../../services/auth.service';
import { catchError, throwError } from 'rxjs';
import { environment } from '../../../environments/environment';


@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule, MatInputModule, MatButtonModule, MatCardModule, MatFormFieldModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  router = inject(Router);
  private _snackBar = inject(MatSnackBar);
  authService = inject(AuthService);
  loginForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required])
  })

  onLogin() {
    if(this.loginForm.invalid) {
      this._snackBar.open('Invalid form', 'Close', {
        duration: 2000,
      });
      return;
    }
    const authUserReqeust: AuthUserRequest = {
      username: this.loginForm.value.email || '', 
      password: this.loginForm.value.password || ''
    }
    this.authService.login(authUserReqeust)
    .pipe(
      catchError((error: HttpErrorResponse) => {
        this._snackBar.open('Invalid credentials', 'Close', {
          duration: 2000,
          verticalPosition: 'top',
          horizontalPosition: 'center'
        });
        return throwError(() => new Error("Error : " + error)); 
      }))
    .subscribe((result) => {
      this.authService.saveToken(result.body.token, result.body.refreshToken);
      this.router.navigate(['products']);
    })
  }

}
