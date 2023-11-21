import { Injectable } from "@angular/core";









@Injectable({
    providedIn: 'root',
  })
export class AuthService {


    public hasAnyRole(roles: Array<string>): boolean {
        return true;
    }


    
}