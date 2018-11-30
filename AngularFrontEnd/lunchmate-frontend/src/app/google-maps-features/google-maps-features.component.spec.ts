import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GoogleMapsFeaturesComponent } from './google-maps-features.component';

describe('GoogleMapsFeaturesComponent', () => {
  let component: GoogleMapsFeaturesComponent;
  let fixture: ComponentFixture<GoogleMapsFeaturesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GoogleMapsFeaturesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GoogleMapsFeaturesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
