import { Injectable } from "@angular/core";
import { User } from "../model/models";


@Injectable({
    providedIn: 'root',
  })
export class AuthService {

    public storeUser(user: User): void {
        localStorage.setItem('name', user.name);
        localStorage.setItem('roles', JSON.stringify(user.roles));
    }

    public isLoggedIn(): boolean {
        const name = localStorage.getItem('name');
        if (name === null) {
            return false;
        }
        return true;
    }

    public getUserName(): string {
        const name = localStorage.getItem('name');
        if (name === null) {
            return '';
        }
        return name 
    }

    public getRoles(): Array<string> {
        const roles = localStorage.getItem('roles');
        if (roles === null) {
            return [];
        }
        return JSON.parse(roles);
    }


    public hasRole(role: string): boolean {
        const roles = this.getRoles();
        if(roles.includes(role)){
            return true;
        }
        return false;
    }


    public hasAnyRole(roles: Array<string>): boolean {
        return true;
        if(roles.includes('everyone')){
            return true;
        }
        //if(!roles.includes('everyone')){ }
        //return false;
        return false;
    }
}