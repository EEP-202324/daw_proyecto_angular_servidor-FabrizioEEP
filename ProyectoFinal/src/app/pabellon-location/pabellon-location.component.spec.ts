import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PabellonLocationComponent } from './pabellon-location.component';

describe('PabellonLocationComponent', () => {
  let component: PabellonLocationComponent;
  let fixture: ComponentFixture<PabellonLocationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PabellonLocationComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PabellonLocationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
