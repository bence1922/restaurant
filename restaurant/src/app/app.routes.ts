import { Route, Routes } from '@angular/router';
import { HomeComponent } from './components/Home/home.component';
import { MenuComponent } from './components/Menu/menu.component';
import { ProfileComponent } from './components/Profile/profile.component';
import { ReservationComponent } from './components/Reservation/reservation.component';
import { AboutUsComponent } from './components/AboutUs/about-us.component';
//import { HeroComponent } from './components/Hero/hero.component';

export const appRoutes: Route[] = [

    {
        path: '',
        //[canActivate: [AuthGuard]] // TODO: Add AuthGuard
        children: [
            {path:'', redirectTo: 'home', pathMatch: 'full'},
            {path:'home', title:'Fő oldal', component: HomeComponent},
            {path:'menu',  title:'Menu', component: MenuComponent},
            {path:'profile',  title:'Profil', component: ProfileComponent},
            {path:'reservation',  title:'Foglalás', component: ReservationComponent},
            {path:'about-us',  title:'Rólunk', component: AboutUsComponent},
            //{path: 'hero',  component: HeroComponent}
        ]
    },
    
];


// // In the main application:
// export const ROUTES: Route[] = [
//     {path: 'admin', loadChildren: () => import('./admin/routes')},
//     // ...
//   ];
  
//   // In admin/routes.ts:
//   export default [
//     {path: 'home', component: AdminHomeComponent},
//     {path: 'users', component: AdminUsersComponent},
//     // ...
//   ] as Route[];