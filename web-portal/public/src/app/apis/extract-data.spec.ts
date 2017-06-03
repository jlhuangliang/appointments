import { extractData } from './extract-data';
import { Response } from '@angular/http';
describe('extractData utility', () => {
  it('should extract data if response has data property', () => {
    const data = extractData({json: () => ({data: [1, 2]})} as Response);
    expect(data).toEqual([1, 2]);
  });

  it('should extract data if response has not data property', () => {
    const data = extractData({json: () => [1, 2]} as Response);
    expect(data).toEqual([1, 2]);
  });
});
