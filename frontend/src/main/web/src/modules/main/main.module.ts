import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainPageComponent } from './components/main-page/main-page.component';
import { ReceiptItemComponent } from './components/receipt-item/receipt-item.component';



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
