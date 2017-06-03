import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientShowComponent } from './show.component';
import { PatientApi } from '../../../apis/patient.api';
import { ActivatedRoute } from '@angular/router';
import { DebugElement } from '@angular/core';
import { By } from '@angular/platform-browser';
import { mockApiModules } from '../../../mock/mock-api-module';

describe('PatientShowComponent', () => {
  let component: PatientShowComponent;
  let element: DebugElement;
  let fixture: ComponentFixture<PatientShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [...mockApiModules],
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
