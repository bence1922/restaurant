import { Injectable } from "@angular/core";


@Injectable({
    providedIn: 'root',
  })
export class AuthService {

    public hasRole(role: string): boolean {

        return true
    }


    public hasAnyRole(roles: Array<string>): boolean {
        if(roles.includes('everyone')){
            console.log('everyone');
            return true;
        }
        if(!roles.includes('everyone')){
            console.log('not everyone');
        }
        //return false;
        return false;
    }


    
}
Írni: login adjon vissza mindent ami kell --> role-ok és mindenkinek (sime usernek is lehessenek role-jai, mert bejelentkezénél az kell) -user/waiter/manager/admin role-ok kellenek