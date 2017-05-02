export class PatientModel {
  patientId: string; // 'p001'
  name: string; // 'Zhang San'
  posted: Date; // '2016-04-23T00:00:00+0800'

  static of(rawData: any): PatientModel {
    if (!rawData) {
      return;
    }
    const result = new PatientModel();

    result.patientId = rawData.patientId;
    result.name = rawData.name;
    result.posted = new Date(rawData.posted);

    return result;
  }

  static from(rawData: any[]): PatientModel[] {
    return rawData.map(PatientModel.of);
  }

}
