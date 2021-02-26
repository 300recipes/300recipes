import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReceiptPageComponent } from './receipt-page/receipt-page.component';



@NgModule({
  declarations: [ReceiptPageComponent],
  exports: [ReceiptPageComponent],
  imports: [
    CommonModule
  ]
})
export class ReceiptModule { }
