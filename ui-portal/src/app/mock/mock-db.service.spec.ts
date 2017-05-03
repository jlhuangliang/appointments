import { TestBed, inject } from '@angular/core/testing';

import { MockDbService } from './mock-db.service';

describe('MockDbService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MockDbService]
    });
  });

  it('should ...', inject([MockDbService], (service: MockDbService) => {
    expect(service).toBeTruthy();
  }));
});
