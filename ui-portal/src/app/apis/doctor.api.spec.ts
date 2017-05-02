import { async, inject, TestBed } from '@angular/core/testing';

import { DoctorApi } from './doctor.api';
import { InMemoryApiService } from '../mock/in-memory-api.service';
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { HttpModule } from '@angular/http';

describe('DoctorApi', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpModule, InMemoryWebApiModule.forRoot(InMemoryApiService)],
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