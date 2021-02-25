import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainPageComponent } from './components/main-page/main-page.component';
import { ReceiptItemListComponent } from './components/receipt-item/receipt-item-list.component';



@NgModule({
  declarations: [MainPageComponent, ReceiptItemListComponent],
  exports: [
    MainPageComponent
  ],
  imports: [
    CommonModule
  ]
})
export class MainModule { }
