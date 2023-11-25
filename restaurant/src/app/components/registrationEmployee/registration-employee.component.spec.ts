import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RegistrationEmployeeComponent } from './registration-employee.component';

describe('RegistrationEmployeeComponent', () => {
  let component: RegistrationEmployeeComponent;
  let fixture: ComponentFixture<RegistrationEmployeeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegistrationEmployeeComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(RegistrationEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
