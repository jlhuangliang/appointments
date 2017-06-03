import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorShowComponent } from './show.component';
import { DoctorApi } from '../../../apis/doctor.api';
import { ActivatedRoute } from '@angular/router';
import { DebugElement } from '@angular/core';
import { By } from '@angular/platform-browser';
import { mockApiModules } from '../../../mock/mock-api-module';

describe('DoctorShowComponent', () => {
  let component: DoctorShowComponent;
  let element: DebugElement;
  let fixture: ComponentFixture<DoctorShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [...mockApiModules],
      declarations: [DoctorShowComponent],
      providers: [
        DoctorApi,
        {
          provide: ActivatedRoute,
          useValue: {
            snapshot: {
              params: {
                id: 'd001',
              },
            },
          },
        },
      ],
    })
      .compileComponents();
  }));

  beforeEach((done) => {
    fixture = TestBed.createComponent(DoctorShowComponent);
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
    expect(element.query(By.css('#doctor-name')).nativeElement.textContent).toEqual('Li Shizhen');
  });
});
