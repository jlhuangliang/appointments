import { async, inject, TestBed } from '@angular/core/testing';

import { AppointmentApi } from './appointment.api';
import { mockApiModules } from '../mock/mock-api-module';

describe('AppointmentApi', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [...mockApiModules],
      providers: [AppointmentApi],
    });
  });

  let api: AppointmentApi;

  beforeEach(inject([AppointmentApi], (service: AppointmentApi) => {
    api = service;
  }));

  it('should be creatable', () => {
    expect(api).toBeTruthy();
  });
  it('should query items', async(() => {
    api.query().subscribe((items) => {
      expect(items.length).toEqual(2);
      expect(items[0].appointmentId).toEqual('a001');
    });
  }));
});
