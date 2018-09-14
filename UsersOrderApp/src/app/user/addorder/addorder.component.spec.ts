import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddorderComponent } from './addorder.component';

describe('AddorderComponent', () => {
  let component: AddorderComponent;
  let fixture: ComponentFixture<AddorderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddorderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddorderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
