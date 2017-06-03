import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { MockDbService } from './mock-db.service';
import { HttpModule } from '@angular/http';
export const mockApiModules = [
  HttpModule,
  InMemoryWebApiModule.forRoot(MockDbService, {delay: 0})
];
