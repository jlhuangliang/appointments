export class AppointmentModel {
  appointmentId: string; // 'a001'
  doctorId: string; // 'd001'
  patientId: string; // 'p001'
  start: Date; // '2017-05-01T14:00:00+0800'
  end: Date; // '2017-05-01T15:00+0800'
  static of(rawData: any): AppointmentModel {
    if (!rawData) {
      return;
    }
    const result = new AppointmentModel();

    result.appointmentId = rawData.appointmentId;
    result.doctorId = rawData.doctorId;
    result.patientId = rawData.patientId;
    result.start = new Date(rawData.start);
    result.end = new Date(rawData.end);

    return result;
  }

  static from(rawData: any[]): AppointmentModel[] {
    return rawData.map(AppointmentModel.of);
  }

}
