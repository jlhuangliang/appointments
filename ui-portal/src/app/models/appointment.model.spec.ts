import { AppointmentModel } from './appointment.model';
import { isDate } from 'util';
import { appointments } from '../mock/appointments';

describe('Appointment Model', () => {
  it('should be creatable', () => {
    const value = new AppointmentModel();
    expect(value).toBeDefined();
  });
  it('AppointmentModel.of should generate an AppointmentModel from rawData', () => {
    const item = AppointmentModel.of(appointments[0]);
    expect(item.doctorId).toEqual('d001');
    expect(isDate(item.start)).toBeTruthy();
  });
  it('AppointmentModel.from should generate an AppointModel array from rawData', () => {
    const items = AppointmentModel.from(appointments);
    expect(items[1].doctorId).toEqual('d002');
    expect(items[1].start.toISOString()).toEqual('2017-05-01T08:00:00.000Z');
  });
});
