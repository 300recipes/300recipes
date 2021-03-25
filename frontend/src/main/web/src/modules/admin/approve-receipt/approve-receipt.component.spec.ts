import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApproveReceiptComponent } from './approve-receipt.component';

describe('ApproveReceiptComponent', () => {
  let component: ApproveReceiptComponent;
  let fixture: ComponentFixture<ApproveReceiptComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApproveReceiptComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApproveReceiptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
