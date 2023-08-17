import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContactnavbarComponent } from './contactnavbar.component';

describe('ContactnavbarComponent', () => {
  let component: ContactnavbarComponent;
  let fixture: ComponentFixture<ContactnavbarComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ContactnavbarComponent]
    });
    fixture = TestBed.createComponent(ContactnavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
