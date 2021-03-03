import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReceiptPageComponent } from './receipt-page/receipt-page.component';
import { CreateReceiptPageComponent } from './create-receipt-page/create-receipt-page.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';



@NgModule({
  declarations: [ReceiptPageComponent, CreateReceiptPageComponent],
  exports: [ReceiptPageComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
  ]
})
export class ReceiptModule { }
