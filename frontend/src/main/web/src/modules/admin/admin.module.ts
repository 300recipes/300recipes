import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApproveListComponent } from './approve-list/approve-list.component';
import { ApproveReceiptComponent } from './approve-receipt/approve-receipt.component';
import { ReceiptModule } from '../receipt/receipt.module';
import { MainModule } from '../main/main.module';



@NgModule({
  declarations: [ApproveListComponent, ApproveReceiptComponent],
  imports: [
    CommonModule,
    MainModule,
    ReceiptModule
  ]
})
export class AdminModule { }
