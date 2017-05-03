import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientShowComponent } from './show.component';
import { HttpModule } from '@angular/http';
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { MockDbService } from '../../../mock/mock-db.service';
import { PatientApi } from '../../../apis/patient.api';
import { ActivatedRoute } from '@angular/router';
import { DebugElement } from '@angular/core';
import { By } from '@angular/platform-browser';

describe('PatientShowComponent', () => {
  let component: PatientShowComponent;
  let element: DebugElement;
  let fixture: ComponentFixture<PatientShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [HttpModule, InMemoryWebApiModule.forRoot(MockDbService, {delay: 0})],
      declarations: [PatientShowComponent],
      providers: [PatientApi,
        {
          provide: ActivatedRoute,
          useValue: {
            snapshot: {
              params: {
                id: 'p001',
              },
            },
          },
        },
      ],
    })
      .compileComponents();
  }));

  beforeEach((done) => {
    fixture = TestBed.createComponent(PatientShowComponent);
    component = fixture.componentInstance;
    element = fixture.debugElement;
    fixture.detectChanges();
    fixture.whenStable().then(() => {
      fixture.detectChanges();
      done();
    });
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should show name', () => {
    expect(element.query(By.css('#patient-name')).nativeElement.textContent).toEqual('Zhang San');
  });
});
