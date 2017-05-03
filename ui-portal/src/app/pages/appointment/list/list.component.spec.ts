import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppointmentListComponent } from './list.component';
import { MockRouterLinkDirective } from '../../../mock/router-link.directive';
import { AppointmentApi } from '../../../apis/appointment.api';
import 'rxjs/add/observable/of';
import { DebugElement } from '@angular/core';
import { DoctorNamePipe } from '../../../pipes/doctor-name.pipe';
import { DoctorApi } from '../../../apis/doctor.api';
import { HttpModule } from '@angular/http';
import { MockDbService } from '../../../mock/mock-db.service';
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { By } from '@angular/platform-browser';
import { PatientNamePipe } from '../../../pipes/patient-name.pipe';
import { PatientApi } from '../../../apis/patient.api';

describe('AppointmentListComponent', () => {
  let component: AppointmentListComponent;
  let element: DebugElement;
  let fixture: ComponentFixture<AppointmentListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [HttpModule, InMemoryWebApiModule.forRoot(MockDbService)],
      declarations: [AppointmentListComponent, MockRouterLinkDirective, DoctorNamePipe, PatientNamePipe],
      providers: [
        AppointmentApi,
        DoctorApi,
        PatientApi,
      ],
    })
      .compileComponents();
  }));

  beforeEach((done) => {
    fixture = TestBed.createComponent(AppointmentListComponent);
    component = fixture.componentInstance;
    element = fixture.debugElement;
    fixture.detectChanges();
    fixture.whenStable().then(() => {
      fixture.detectChanges();
      done();
    });
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should show rows', () => {
    expect(element.queryAll(By.css('table>tbody>tr')).length).toEqual(2);
  });
  it('should show cols in first row', () => {
    const cols = element.queryAll(By.css('table>tbody>tr:first-child>td'));
    expect(cols.length).toEqual(5);
    expect(cols[0].nativeElement.textContent.trim()).toEqual('a001');
    expect(cols[4].nativeElement.textContent.trim()).toEqual('May 1, 2017');
  });
});
