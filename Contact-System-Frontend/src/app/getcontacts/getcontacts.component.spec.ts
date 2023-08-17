import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetcontactsComponent } from './getcontacts.component';

describe('GetcontactsComponent', () => {
  let component: GetcontactsComponent;
  let fixture: ComponentFixture<GetcontactsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GetcontactsComponent]
    });
    fixture = TestBed.createComponent(GetcontactsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
