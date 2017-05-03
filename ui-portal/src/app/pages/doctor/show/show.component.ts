import { Component, OnInit } from '@angular/core';
import { DoctorApi } from '../../../apis/doctor.api';
import { ActivatedRoute } from '@angular/router';
import { DoctorModel } from '../../../models/doctor.model';

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.scss'],
})
export class DoctorShowComponent implements OnInit {

  item: DoctorModel;

  constructor(private api: DoctorApi, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.api.get(this.route.snapshot.params.id).subscribe((item) => this.item = item);
  }
}
