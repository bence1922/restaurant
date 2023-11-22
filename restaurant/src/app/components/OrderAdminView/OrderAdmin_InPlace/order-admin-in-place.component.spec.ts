import { ComponentFixture, TestBed } from '@angular/core/testing';
import { OrderAdminInPlaceComponent } from './order-admin-in-place.component';

describe('OrderAdminInPlaceComponent', () => {
  let component: OrderAdminInPlaceComponent;
  let fixture: ComponentFixture<OrderAdminInPlaceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OrderAdminInPlaceComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(OrderAdminInPlaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
