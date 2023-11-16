import { ApplicationConfig } from '@angular/core';
import { HttpClientModule, provideHttpClient } from '@angular/common/http';
import {
  provideRouter,
  withEnabledBlockingInitialNavigation,
} from '@angular/router';
import { appRoutes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [provideRouter(appRoutes),
    provideHttpClient()
  ],
};
