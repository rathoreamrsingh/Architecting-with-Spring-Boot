import { NgModule } from '../../node_modules/@angular/core';
import {Routes, RouterModule} from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { HomeComponent } from './user/home/home.component';
import { AddorderComponent } from './user/addorder/addorder.component';

const routes: Routes = [
{ path: '', component: LoginComponent},
{ path: 'login', component: LoginComponent},
{ path: 'signup', component: SignupComponent},
{ path: 'dashboard', component: HomeComponent},
{ path: 'addorder', component: AddorderComponent},

];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]})
export class AppRoutingModule {}
