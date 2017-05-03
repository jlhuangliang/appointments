import { Response } from '@angular/http';
export function extractData(response: Response): object {
  const json = response.json();
  if (json.data) {
    return json.data;
  } else {
    return json;
  }
}
