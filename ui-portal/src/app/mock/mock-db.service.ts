import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';
import { appointments } from './appointments';
import { doctors } from './doctors';
import { patients } from './patients';

@Injectable()
export class MockDbService implements InMemoryDbService {
  constructor() {
  }

  createDb(): {} {
    return {appointments, doctors, patients};
  }
}
