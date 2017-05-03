import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { MockDbService } from './mock/mock-db.service';
import { AppointmentListComponent } from './pages/appointment/list/list.component';
import { AppointmentShowComponent } from './pages/appointment/show/show.component';
import { AppointmentApi } from './apis/appointment.api';
import { DoctorApi } from './apis/doctor.api';
import { PatientApi } from './apis/patient.api';
import { MockRouterLinkDirective } from './mock/router-link.directive';
import { DoctorNamePipe } from './pipes/doctor-name.pipe';
import { DoctorShowComponent } from './pages/doctor/show/show.component';
import { PatientShowComponent } from './pages/patient/show/show.component';
import { PatientNamePipe } from './pipes/patient-name.pipe';

@NgModule({
  declarations: [
    AppComponent,
    AppointmentListComponent,
    AppointmentShowComponent,
    MockRouterLinkDirective,
    DoctorNamePipe,
    DoctorShowComponent,
    PatientShowComponent,
    PatientNamePipe,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    InMemoryWebApiModule.forRoot(MockDbService),
    AppRoutingModule,
  ],
  providers: [AppointmentApi, DoctorApi, PatientApi],
  bootstrap: [AppComponent],
})
export class AppModule {
}
