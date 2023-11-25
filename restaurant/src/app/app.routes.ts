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
import { RoleGuard } from './guards/auth.guard';
import { IngredientsComponent } from './components/Ingredients/ingredients.component';
import { TablesComponent } from './components/Tables/tables.component';
import { OrderAdminComponent } from './components/OrderAdminView/OrderAdmin/order-admin.component';
import { OrderAdminInPlaceComponent } from './components/OrderAdminView/OrderAdmin_InPlace/order-admin-in-place.component';
import { OrderAdminDeliveryComponent } from './components/OrderAdminView/OrderAdmin_Delivery/order-admin-delivery.component';

import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { AdminReservationsComponent } from './components/AdminReservations/admin-reservations.component';
import { RegistrationEmployeeComponent } from './components/registrationEmployee/registration-employee.component';
//import { HeroComponent } from './components/Hero/hero.component';

export const appRoutes: Route[] = [

    {
        path: '',
        //[canActivate: [AuthGuard]] // TODO: Add AuthGuard
        children: [
            {path:'', redirectTo: 'home', pathMatch: 'full'},
            {path:'home', title:'Fő oldal', component: HomeComponent, canActivate: [RoleGuard], data: {roles: ['everyone']}},
            {path:'menu',  title:'Menu', component: MenuComponent, canActivate: [RoleGuard], data: {roles: ['everyone']}},
            {path:'profile',  title:'Profil', component: ProfileComponent, canActivate: [RoleGuard], data: {roles: ['user']},
                children:[{path: 'datas', component: ProfileProfileComponent},
                            {path: 'orders', component: OrdersProfileComponent},
                            {path: 'reservations', component: ReservationsProfileComponent}]},
            {path: 'tables', title:"Asztalok", component: TablesComponent, canActivate: [RoleGuard], data: {roles: ['admin', 'waiter', 'manager']}},
            {path: 'orderadmin', title: "Rednelések", component: OrderAdminComponent, canActivate: [RoleGuard], data: {roles: ['admin', 'waiter', 'manager']},
                    children:[
                        {path: 'inplace', component: OrderAdminInPlaceComponent },
                        {path: 'delivery', component: OrderAdminDeliveryComponent }
                    ]},
            {path:'reservation',  title:'Foglalás', component: ReservationComponent, canActivate: [RoleGuard], data: {roles: ['everyone']}},
            {path:'about-us',  title:'Rólunk', component: AboutUsComponent, canActivate: [RoleGuard], data: {roles: ['everyone']}},
            {path: 'order', title:'Rendelés', component: OrderComponent, canActivate: [RoleGuard], data: {roles: ['everyone']}},
            {path:'employees', title:'Dolgozók', component: EmployeesComponent, canActivate: [RoleGuard], data: {roles: ['admin']}},
            {path: 'ingredients', title:'Alapanyagok', component: IngredientsComponent, canActivate: [RoleGuard], data: {roles: ['admin', 'manager']}},
            {path: 'login', title:'Log In', component: LoginComponent, canActivate: [RoleGuard], data: {roles: ['everyone']}},
            {path: 'registration', title:'Registration', component: RegistrationComponent, canActivate: [RoleGuard], data: {roles: ['everyone']}},
            {path: 'registration_employees', title:'Registration of Employees', component: RegistrationEmployeeComponent, canActivate: [RoleGuard], data: {roles: ['admin']}},
            {path: 'tables', title:"Asztalok", component: TablesComponent, canActivate: [RoleGuard], data: {roles: ['admin', 'waiter', 'manager']}},
            {path: 'reservations_admin', title:"Foglalások", component: AdminReservationsComponent, canActivate: [RoleGuard], data: {roles: ['admin','everyone']}},
]}]
//     {path: 'admin', loadChildren: () => import('./admin/routes')},
//     // ...
//   ];
  
//   // In admin/routes.ts:
//   export default [
//     {path: 'home', component: AdminHomeComponent},
//     {path: 'users', component: AdminUsersComponent},
//     // ...
//   ] as Route[];