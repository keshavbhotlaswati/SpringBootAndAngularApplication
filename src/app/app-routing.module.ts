import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { EmployeeComponent } from './employee/employee.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { EditEmployeeComponent } from './edit-employee/edit-employee.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
 
  { path: '', component: LoginComponent },
  { path: 'logout', component: LogoutComponent },
  {path: 'user' , component:UserComponent},
  { path: 'welcome', component: WelcomeComponent },
  { path: 'employee', component: EmployeeComponent},
  {path: 'addEmployee' , component:AddEmployeeComponent},
{path:'editEmployee/:id',component:EditEmployeeComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
