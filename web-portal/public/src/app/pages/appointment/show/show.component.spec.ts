import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppointmentShowComponent } from './show.component';
import { AppointmentApi } from '../../../apis/appointment.api';
import { ActivatedRoute } from '@angular/router';
import { DebugElement } from '@angular/core';
import { By } from '@angular/platform-browser';
import { DoctorNamePipe } from '../../../pipes/doctor-name.pipe';
import { DoctorApi } from '../../../apis/doctor.api';
import { PatientNamePipe } from '../../../pipes/patient-name.pipe';
import { PatientApi } from '../../../apis/patient.api';
import { mockApiModules } from '../../../mock/mock-api-module';
import { RouterTestingModule } from '@angular/router/testing';

describe('AppointmentShowComponent', () => {
  let component: AppointmentShowComponent;
  let element: DebugElement;
  let fixture: ComponentFixture<AppointmentShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [...mockApiModules, RouterTestingModule],
      declarations: [AppointmentShowComponent, DoctorNamePipe, PatientNamePipe],
      providers: [
        AppointmentApi,
        DoctorApi,
        PatientApi,
        {
          provide: ActivatedRoute,
          useValue: {
            snapshot: {
              params: {
                id: 'a001',
              },
            },
          },
        },
      ],
    })
      .compileComponents();
  }));

  beforeEach((done) => {
    fixture = TestBed.createComponent(AppointmentShowComponent);
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
  it('should show details', () => {
    expect(element.query(By.css('#end-time')).nativeElement.textContent.trim()).toEqual('May 1, 2017');
  });
});
