import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';
import { appointments } from './appointments';
import { doctors } from './doctors';

@Injectable()
export class InMemoryApiService implements InMemoryDbService {
  constructor() {
  }

  createDb(): {} {
    return {appointments, doctors};
  }
}
