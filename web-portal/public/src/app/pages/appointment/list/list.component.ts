import { Component, OnInit } from '@angular/core';
import { AppointmentApi } from '../../../apis/appointment.api';
import { AppointmentModel } from '../../../models/appointment.model';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss'],
})
export class AppointmentListComponent implements OnInit {

  items: AppointmentModel[];

  constructor(private api: AppointmentApi) {
  }

  ngOnInit(): void {
    this.api.query()
      .subscribe((items) => this.items = items);
  }

}
