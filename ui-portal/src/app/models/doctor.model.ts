export class DoctorModel {
  doctorId: string; // 'd001'
  name: string; // 'Li Shizhen'
  posted: Date; // new Date('2015-04-23T00:00:00+0800')

  static of(rawData: any): DoctorModel {
    if (!rawData) {
      return;
    }
    const result = new DoctorModel();

    result.doctorId = rawData.doctorId;
    result.name = rawData.name;
    result.posted = new Date(rawData.posted);

    return result;
  }

  static from(rawData: any[]): DoctorModel[] {
    return rawData.map(DoctorModel.of);
  }

}
