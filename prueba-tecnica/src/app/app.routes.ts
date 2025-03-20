import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { canAccessLoginGuard } from './guards/can-access-login.guard';
import { canAccesGuard } from './guards/can-acces.guard';
import { ProductComponent } from './components/product/product.component';

export const routes: Routes = [
    {path: '', component: LoginComponent, title: "Login", canActivate: [canAccessLoginGuard]},
    {path: '', component: NavbarComponent, children: [
        {path: 'products', component: ProductComponent, title: "Tasks", canActivate: [canAccesGuard]},

    ]}
];
