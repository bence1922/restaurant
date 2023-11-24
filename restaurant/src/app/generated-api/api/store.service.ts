import { Injectable } from "@angular/core";
import { User, UserSession } from "../model/models";
import { UserService } from "./user.service";


@Injectable({
    providedIn: 'root',
  })
export class StoreUserService {

    public storeUser(user: UserSession): void {
        localStorage.setItem('id', user.id);
        localStorage.setItem('role', user.role);
        localStorage.setItem('name', user.user.name);
    }

    public isLoggedIn(): boolean {
        const id = localStorage.getItem('id');
        if (id === null) {
            return false;
        }
        return true;
    }

    public getUserId(): string {
        const id = localStorage.getItem('id');
        if (id === null) {
            return '';
        }
        return id
    }

    public getUserName(): string {
        const name = localStorage.getItem('name');
        if (name === null) {
            return '';
        }
        return name 
    }

    public getRole(): string {
        const roles = localStorage.getItem('role');
        if (roles === null) {
            return ''
        }
        return roles;
    }


    public hasRole(role: string): boolean {
        const myrole = this.getRole();
        if(myrole === role){
            return true;
        }
        return false;
    }


    public hasAnyRole(roles: Array<string>): boolean {
        if(roles.includes('everyone')){
            return true;
        }
        if(roles.includes(this.getRole())){
            return true;
        }
        return false;
    }

    public logout(): void {
        localStorage.removeItem('id');
        localStorage.removeItem('role');
        localStorage.removeItem('name');
    }
}