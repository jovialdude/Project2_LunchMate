import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeeallpostingsComponent } from './seeallpostings.component';

describe('SeeallpostingsComponent', () => {
  let component: SeeallpostingsComponent;
  let fixture: ComponentFixture<SeeallpostingsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeeallpostingsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeeallpostingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
