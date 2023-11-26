import { HttpInterceptorFn } from "@angular/common/http";
import { AuthService } from "../generated-api/api/auth.service";
import { inject } from "@angular/core";


export const authInterceptor: HttpInterceptorFn = (request, next) => {
    const authService = inject(AuthService);

    request = addAuthHeader(request);
    
    return next(request);
};

function addAuthHeader(request: any) {
    const token = localStorage.getItem('id');
    if (token) {
        request = request.clone({
            setHeaders: {
                SessionId: token,
            },
        });
    }
    return request;
}