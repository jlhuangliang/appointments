import { DoctorNamePipe } from './doctor-name.pipe';
import { Observable } from 'rxjs/Observable';
import { DoctorModel } from '../models/doctor.model';
import { async } from '@angular/core/testing';

class DoctorApi {
  get(id: string): Observable<DoctorModel> {
    const doctor = DoctorModel.of({id: id, name: 'name:' + id});
    return Observable.of(doctor);
  }
}
describe('DoctorNamePipe', () => {
  const api: any = new DoctorApi();
  it('create an instance', () => {
    const pipe = new DoctorNamePipe(api);
    expect(pipe).toBeTruthy();
  });
  it('should transform id to name', async(() => {
    const pipe = new DoctorNamePipe(api);
    pipe.transform('d001').subscribe((name) => {
      expect(name).toEqual('name:d001');
    });
  }));
});
