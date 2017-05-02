import { DoctorNamePipe } from './doctor-name.pipe';

describe('DoctorNamePipe', () => {
  it('create an instance', () => {
    const pipe = new DoctorNamePipe();
    expect(pipe).toBeTruthy();
  });
});
