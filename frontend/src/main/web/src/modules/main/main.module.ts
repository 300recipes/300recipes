import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainPageComponent } from './components/main-page/main-page.component';
import { ReceiptItemListComponent } from './components/receipt-item/receipt-item-list.component';
import { RouterModule } from "@angular/router";
import { FilterPanelComponent } from './components/filter-panel/filter-panel.component';
import { DropdownComponent } from './components/dropdown/dropdown.component';
import {FormsModule} from "@angular/forms";



@NgModule({
  declarations: [MainPageComponent, ReceiptItemListComponent, FilterPanelComponent, DropdownComponent],
  exports: [
    MainPageComponent,
    ReceiptItemListComponent
  ],
    imports: [
        CommonModule,
        RouterModule,
        FormsModule
    ]
})
export class MainModule { }
