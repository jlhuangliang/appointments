import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';
import { appointments } from './appointments';

@Injectable()
export class InMemoryApiService implements InMemoryDbService {
  constructor() {
  }

  createDb(): {} {
    return {appointments};
  }
}
