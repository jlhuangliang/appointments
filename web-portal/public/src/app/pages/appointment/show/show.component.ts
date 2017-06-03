import { Component, OnInit } from '@angular/core';
import { AppointmentApi } from '../../../apis/appointment.api';
import { AppointmentModel } from '../../../models/appointment.model';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.scss'],
})
export class AppointmentShowComponent implements OnInit {

  item: AppointmentModel;

  constructor(private api: AppointmentApi, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.api.get(this.route.snapshot.params.id)
      .subscribe((item) => this.item = item);
  }

}
