import { Component, OnInit } from '@angular/core';
import { PatientApi } from '../../../apis/patient.api';
import { PatientModel } from '../../../models/patient.model';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.scss'],
})
export class PatientShowComponent implements OnInit {
  item: PatientModel;

  constructor(private api: PatientApi, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.api.get(this.route.snapshot.params.id).subscribe((item) => this.item = item);
  }
}
