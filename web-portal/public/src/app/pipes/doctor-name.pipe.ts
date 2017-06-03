import { Pipe, PipeTransform } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { DoctorApi } from '../apis/doctor.api';

import 'rxjs/add/operator/share';

@Pipe({
  name: 'doctorName',
})
export class DoctorNamePipe implements PipeTransform {
  constructor(private api: DoctorApi) {
  }

  transform(id: string): Observable<string> {
    return this.api.get(id).map((doctor) => doctor.name).share();
  }
}
