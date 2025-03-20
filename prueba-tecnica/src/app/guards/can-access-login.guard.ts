import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { environment } from '../../environments/environment';

export const canAccessLoginGuard: CanActivateFn = (route, state) => {

  const urlDefault = environment.routeLogin;
  const router = inject(Router)
  const token = localStorage.getItem('token');
  if(token) {
    router.navigate(['products']);
    return false;
  }
  return true;
};
