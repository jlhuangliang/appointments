import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorShowComponent } from './show.component';
import { HttpModule } from '@angular/http';
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { MockDbService } from '../../../mock/mock-db.service';
import { DoctorApi } from '../../../apis/doctor.api';
import { ActivatedRoute } from '@angular/router';
import { DebugElement } from '@angular/core';
import { By } from '@angular/platform-browser';

describe('DoctorShowComponent', () => {
  let component: DoctorShowComponent;
  let element: DebugElement;
  let fixture: ComponentFixture<DoctorShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [HttpModule, InMemoryWebApiModule.forRoot(MockDbService, {delay: 0})],
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
