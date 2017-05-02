import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryApiService } from './mock/in-memory-api.service';
import { AppointmentListComponent } from './pages/appointment/list/list.component';
import { AppointmentShowComponent } from './pages/appointment/show/show.component';
import { AppointmentApi } from './apis/appointment.api';
import { DoctorApi } from './apis/doctor.api';
import { PatientApi } from './apis/patient.api';
import { MockRouterLinkDirective } from './mock/router-link.directive';

@NgModule({
  declarations: [
    AppComponent,
    AppointmentListComponent,
    AppointmentShowComponent,
    MockRouterLinkDirective,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    InMemoryWebApiModule.forRoot(InMemoryApiService),
    AppRoutingModule,
  ],
  providers: [AppointmentApi, DoctorApi, PatientApi],
  bootstrap: [AppComponent],
})
export class AppModule {
}
