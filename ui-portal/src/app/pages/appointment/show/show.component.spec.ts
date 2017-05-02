import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppointmentShowComponent } from './show.component';
import { MockRouterLinkDirective } from '../../../mock/router-link.directive';
import { appointments } from '../../../mock/appointments';
import { AppointmentModel } from '../../../models/appointment.model';
import { Observable } from 'rxjs/Observable';
import { AppointmentApi } from '../../../apis/appointment.api';
import { ActivatedRoute } from '@angular/router';
import { DebugElement } from '@angular/core';
import { By } from '@angular/platform-browser';
import { DoctorNamePipe } from '../../../pipes/doctor-name.pipe';

describe('AppointmentShowComponent', () => {
  let component: AppointmentShowComponent;
  let element: DebugElement;
  let fixture: ComponentFixture<AppointmentShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [AppointmentShowComponent, MockRouterLinkDirective, DoctorNamePipe],
      providers: [
        {
          provide: AppointmentApi,
          useValue: {get: () => Observable.of(appointments[0]).map(AppointmentModel.of)},
        },
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

  beforeEach(() => {
    fixture = TestBed.createComponent(AppointmentShowComponent);
    component = fixture.componentInstance;
    element = fixture.debugElement;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should show details', () => {
    expect(element.query(By.css('#end-time')).nativeElement.textContent.trim()).toEqual('May 1, 2017');
  });
});
