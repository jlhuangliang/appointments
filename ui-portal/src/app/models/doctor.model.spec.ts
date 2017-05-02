import { DoctorModel } from './doctor.model';
import { isDate } from 'util';
import { doctors } from '../mock/doctors';

describe('Doctor Model', () => {
  it('should be creatable', () => {
    const value = new DoctorModel();
    expect(value).toBeDefined();
  });
  it('DoctorModel.of should generate an DoctorModel from rawData', () => {
    const item = DoctorModel.of(doctors[0]);
    expect(item.doctorId).toEqual('d001');
    expect(isDate(item.posted)).toBeTruthy();
  });
  it('DoctorModel.from should generate an AppointModel array from rawData', () => {
    const items = DoctorModel.from(doctors);
    expect(items[1].doctorId).toEqual('d002');
    expect(items[1].posted).toEqual(new Date('2015-05-11T16:00:00.000Z'));
  });
});
