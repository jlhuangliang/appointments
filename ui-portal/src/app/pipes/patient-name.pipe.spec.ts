import { PatientNamePipe } from './patient-name.pipe';
import { Observable } from 'rxjs/Observable';
import { PatientModel } from '../models/patient.model';
import { async } from '@angular/core/testing';

class PatientApi {
  get(id: string): Observable<PatientModel> {
    const patient = PatientModel.of({id: id, name: 'name:' + id});
    return Observable.of(patient);
  }
}
describe('PatientNamePipe', () => {
  const api: any = new PatientApi();
  it('create an instance', () => {
    const pipe = new PatientNamePipe(api);
    expect(pipe).toBeTruthy();
  });
  it('should transform id to name', async(() => {
    const pipe = new PatientNamePipe(api);
    pipe.transform('p001').subscribe((name) => {
      expect(name).toEqual('name:p001');
    });
  }));
});
