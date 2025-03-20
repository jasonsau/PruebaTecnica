import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { TaskComponent } from './components/task/task.component';

export const routes: Routes = [
    {path: '', component: LoginComponent, title: "Login"},
    {path: '', component: NavbarComponent, children: [
        {path: 'tasks', component: TaskComponent, title: "Tasks"},

    ]}
];
