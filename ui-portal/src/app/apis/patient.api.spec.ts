import { async, inject, TestBed } from '@angular/core/testing';

import { PatientApi } from './patient.api';
import { HttpModule } from '@angular/http';
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { MockDbService } from '../mock/mock-db.service';

describe('PatientApi', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpModule, InMemoryWebApiModule.forRoot(MockDbService)],
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
