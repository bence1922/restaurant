import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { StoreUserService } from '../generated-api/api/store.service';

@Injectable({
  providedIn: 'root'
})
export class RoleGuard implements CanActivate {

  constructor(private storeUserService: StoreUserService,
    private router: Router,
    ) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    const allowedRoles = next.data['roles'] as Array<string>;

    if (this.storeUserService.hasAnyRole(allowedRoles)) {
      return true;
    } else {
      this.router.navigate(['/login']);
      return false;
    }
  }
}