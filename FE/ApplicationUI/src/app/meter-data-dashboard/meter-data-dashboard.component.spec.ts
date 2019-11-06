import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MeterDataDashboardComponent } from './meter-data-dashboard.component';

describe('MeterDataDashboardComponent', () => {
  let component: MeterDataDashboardComponent;
  let fixture: ComponentFixture<MeterDataDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MeterDataDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MeterDataDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
