import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainPageComponent } from './main-page/main-page.component';
import { ReceiptItemComponent } from './receipt-item/receipt-item.component';



@NgModule({
  declarations: [MainPageComponent, ReceiptItemComponent],
  exports: [
    MainPageComponent
  ],
  imports: [
    CommonModule
  ]
})
export class MainModule { }
