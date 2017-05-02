import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { DoctorModel } from '../models/doctor.model';

@Injectable()
export class DoctorApi {

  constructor(private http: Http) {
  }

  query(): Observable<DoctorModel[]> {
    return this.http.get('/api/doctors')
      .map(resp => resp.json().data)
      .map(DoctorModel.from);
  }

  get(id: string): Observable<DoctorModel> {
    return this.http.get(`/api/doctors/${id}`)
      .map(resp => resp.json().data)
      .map(DoctorModel.of);
  }
}
