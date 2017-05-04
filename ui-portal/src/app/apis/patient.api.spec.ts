import { async, inject, TestBed } from '@angular/core/testing';

import { PatientApi } from './patient.api';
import { mockApiModules } from '../mock/mock-api-module';

describe('PatientApi', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [...mockApiModules],
      providers: [PatientApi],
    });
  });

  let api: PatientApi;

  beforeEach(inject([PatientApi], (service: PatientApi) => {
    api = service;
  }));

  it('should be creatable', () => {
    expect(api).toBeTruthy();
  });
  it('should query items', async(() => {
    api.query().subscribe((items) => {
      expect(items.length).toEqual(3);
      expect(items[0].patientId).toEqual('p001');
    });
  }));
});
