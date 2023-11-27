import { ComponentFixture, TestBed } from '@angular/core/testing';
import { OrderAdminDeliveryComponent } from './order-admin-delivery.component';

describe('OrderAdminDeliveryComponent', () => {
  let component: OrderAdminDeliveryComponent;
  let fixture: ComponentFixture<OrderAdminDeliveryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OrderAdminDeliveryComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(OrderAdminDeliveryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
