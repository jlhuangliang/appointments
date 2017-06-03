import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { AppointmentModel } from '../models/appointment.model';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import { extractData } from './extract-data';

@Injectable()
export class AppointmentApi {

  constructor(private http: Http) {
  }

  query(): Observable<AppointmentModel[]> {
    return this.http.get('/api/appointments')
      .map(extractData)
      .map(AppointmentModel.from);
  }

  get(id: string): Observable<AppointmentModel> {
    return this.http.get(`/api/appointments/${id}`)
      .map(extractData)
      .map(AppointmentModel.of);
  }
}
