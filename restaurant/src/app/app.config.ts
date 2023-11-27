import { ApplicationConfig } from '@angular/core';
import { HttpClientModule, provideHttpClient, withInterceptors } from '@angular/common/http';
import {
  provideRouter,
  withEnabledBlockingInitialNavigation,
} from '@angular/router';
import { appRoutes } from './app.routes';
import { authInterceptor } from './interceptors/auth.interceptor';
import {provideAnimations} from '@angular/platform-browser/animations'
import { CookieService } from 'ngx-cookie-service';
import { errorInterceptor } from './interceptors/error-handler.interceptor';


export const appConfig: ApplicationConfig = {
  providers: [provideRouter(appRoutes),
    provideHttpClient(withInterceptors([authInterceptor, errorInterceptor])),
    provideAnimations(),
    CookieService
  ],
};
