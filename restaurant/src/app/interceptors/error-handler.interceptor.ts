import {
  HttpInterceptorFn,
  HttpErrorResponse
} from '@angular/common/http';
import { catchError, throwError } from 'rxjs';

export const errorInterceptor: HttpInterceptorFn = (request, next) => {
  return next(request).pipe(
    catchError((error: HttpErrorResponse) => {
      let errorMsg = `Error Code: ${error.status}, Message: ${error.error}`;
      alert(errorMsg)
      return throwError(errorMsg);
    })
  );
};