import { Pipe, PipeTransform } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { PatientApi } from '../apis/patient.api';

@Pipe({
  name: 'patientName',
})
export class PatientNamePipe implements PipeTransform {
  constructor(private api: PatientApi) {
  }

  transform(id: string): Observable<string> {
    return this.api.get(id).map((patient) => patient.name);
  }
}
