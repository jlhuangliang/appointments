import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { AppointmentModel } from '../models/appointment.model';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';

@Injectable()
export class AppointmentApi {

  constructor(private http: Http) {
  }

  query(): Observable<AppointmentModel[]> {
    return this.http.get('/api/appointments')
      .map(resp => resp.json().data)
      .map(AppointmentModel.from);
  }

  get(id: string): Observable<AppointmentModel> {
    return this.http.get(`/api/appointments/${id}`)
      .map(resp => resp.json().data)
      .map(AppointmentModel.of);
  }
}
