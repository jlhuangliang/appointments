import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { PatientModel } from '../models/patient.model';
import { Http } from '@angular/http';
import { extractData } from './extract-data';

@Injectable()
export class PatientApi {

  constructor(private http: Http) {
  }

  query(): Observable<PatientModel[]> {
    return this.http.get('/api/patients')
      .map(extractData)
      .map(PatientModel.from);
  }

  get(id: string): Observable<PatientModel> {
    return this.http.get(`/api/patients/${id}`)
      .map(extractData)
      .map(PatientModel.of);
  }
}
