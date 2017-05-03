import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppointmentShowComponent } from './show.component';
import { MockRouterLinkDirective } from '../../../mock/router-link.directive';
import { AppointmentApi } from '../../../apis/appointment.api';
import { ActivatedRoute } from '@angular/router';
import { DebugElement } from '@angular/core';
import { By } from '@angular/platform-browser';
import { DoctorNamePipe } from '../../../pipes/doctor-name.pipe';
import { HttpModule } from '@angular/http';
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { MockDbService } from '../../../mock/mock-db.service';
import { DoctorApi } from '../../../apis/doctor.api';
import { PatientNamePipe } from '../../../pipes/patient-name.pipe';
import { PatientApi } from '../../../apis/patient.api';

describe('AppointmentShowComponent', () => {
  let component: AppointmentShowComponent;
  let element: DebugElement;
  let fixture: ComponentFixture<AppointmentShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [HttpModule, InMemoryWebApiModule.forRoot(MockDbService)],
      declarations: [AppointmentShowComponent, MockRouterLinkDirective, DoctorNamePipe, PatientNamePipe],
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
