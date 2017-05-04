import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppointmentListComponent } from './list.component';
import { AppointmentApi } from '../../../apis/appointment.api';
import 'rxjs/add/observable/of';
import { DebugElement } from '@angular/core';
import { DoctorNamePipe } from '../../../pipes/doctor-name.pipe';
import { DoctorApi } from '../../../apis/doctor.api';
import { By } from '@angular/platform-browser';
import { PatientNamePipe } from '../../../pipes/patient-name.pipe';
import { PatientApi } from '../../../apis/patient.api';
import { mockApiModules } from '../../../mock/mock-api-module';
import { RouterTestingModule } from '@angular/router/testing';

describe('AppointmentListComponent', () => {
  let component: AppointmentListComponent;
  let element: DebugElement;
  let fixture: ComponentFixture<AppointmentListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [...mockApiModules, RouterTestingModule],
      declarations: [AppointmentListComponent, DoctorNamePipe, PatientNamePipe],
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
