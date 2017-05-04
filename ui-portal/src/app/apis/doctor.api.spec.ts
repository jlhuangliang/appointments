import { async, inject, TestBed } from '@angular/core/testing';

import { DoctorApi } from './doctor.api';
import { mockApiModules } from '../mock/mock-api-module';

describe('DoctorApi', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [...mockApiModules],
      providers: [DoctorApi],
    });
  });

  let api: DoctorApi;

  beforeEach(inject([DoctorApi], (service: DoctorApi) => {
    api = service;
  }));

  it('should be creatable', () => {
    expect(api).toBeTruthy();
  });
  it('should query items', async(() => {
    api.query().subscribe((items) => {
      expect(items.length).toEqual(3);
      expect(items[0].doctorId).toEqual('d001');
    });
  }));
});
