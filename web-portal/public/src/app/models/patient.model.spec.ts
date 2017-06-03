import { PatientModel } from './patient.model';
import { isDate } from 'util';
import { patients } from '../mock/patients';

describe('Patient Model', () => {
  it('should be creatable', () => {
    const value = new PatientModel();
    expect(value).toBeDefined();
  });
  it('PatientModel.of should generate an PatientModel from rawData', () => {
    const item = PatientModel.of(patients[0]);
    expect(item.patientId).toEqual('p001');
    expect(isDate(item.posted)).toBeTruthy();
  });
  it('PatientModel.from should generate an AppointModel array from rawData', () => {
    const items = PatientModel.from(patients);
    expect(items[1].patientId).toEqual('p002');
    expect(items[1].posted).toEqual(new Date('2016-05-12T00:00:00+0800'));
  });
});
