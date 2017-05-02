import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppointmentListComponent } from './pages/appointment/list/list.component';
import { AppointmentShowComponent } from './pages/appointment/show/show.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: '/appointments',
  },
  {
    path: 'appointments/:id',
    component: AppointmentShowComponent,
  },
  {
    path: 'appointments',
    component: AppointmentListComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
