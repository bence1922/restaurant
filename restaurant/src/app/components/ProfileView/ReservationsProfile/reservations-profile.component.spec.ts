import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReservationsProfileComponent } from './reservations-profile.component';

describe('ReservationsProfileComponent', () => {
  let component: ReservationsProfileComponent;
  let fixture: ComponentFixture<ReservationsProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ReservationsProfileComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(ReservationsProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
