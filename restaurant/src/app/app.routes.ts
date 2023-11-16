import { Route, Routes } from '@angular/router';
import { HomeComponent } from './components/Home/home.component';
import { MenuComponent } from './components/Menu/menu.component';
import { ProfileComponent } from './components/ProfileView/Profile/profile.component';
import { ReservationComponent } from './components/Reservation/reservation.component';
import { AboutUsComponent } from './components/AboutUs/about-us.component';
import { ProfileProfileComponent } from './components/ProfileView/ProfileProfile/profile-profile.component';
import { OrdersProfileComponent } from './components/ProfileView/OrdersProfile/orders-profile.component';
import { ReservationsProfileComponent } from './components/ProfileView/ReservationsProfile/reservations-profile.component';
import { OrderComponent } from './components/Order/order.component';
import { EmployeesComponent } from './components/Employees/employees.component';
//import { HeroComponent } from './components/Hero/hero.component';

export const appRoutes: Route[] = [

    {
        path: '',
        //[canActivate: [AuthGuard]] // TODO: Add AuthGuard
        children: [
            {path:'', redirectTo: 'home', pathMatch: 'full'},
            {path:'home', title:'Fő oldal', component: HomeComponent},
            {path:'menu',  title:'Menu', component: MenuComponent},
            {path:'profile',  title:'Profil', component: ProfileComponent,
                children:[{path: 'datas', component: ProfileProfileComponent},
                            {path: 'orders', component: OrdersProfileComponent},
                            {path: 'reservations', component: ReservationsProfileComponent}]},
            {path:'reservation',  title:'Foglalás', component: ReservationComponent},
            {path:'about-us',  title:'Rólunk', component: AboutUsComponent},
            {path: 'order', title:'Rendelés', component: OrderComponent},
            {path:'employees', title:'Dolgozók', component: EmployeesComponent}]}]
//     {path: 'admin', loadChildren: () => import('./admin/routes')},
//     // ...
//   ];
  
//   // In admin/routes.ts:
//   export default [
//     {path: 'home', component: AdminHomeComponent},
//     {path: 'users', component: AdminUsersComponent},
//     // ...
//   ] as Route[];