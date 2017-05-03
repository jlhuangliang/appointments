import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { DoctorModel } from '../models/doctor.model';
import { extractData } from './extract-data';

@Injectable()
export class DoctorApi {

  constructor(private http: Http) {
  }

  query(): Observable<DoctorModel[]> {
    return this.http.get('/api/doctors')
      .map(extractData)
      .map(DoctorModel.from);
  }

  get(id: string): Observable<DoctorModel> {
    return this.http.get(`/api/doctors/${id}`)
      .map(extractData)
      .map(DoctorModel.of);
  }
}
