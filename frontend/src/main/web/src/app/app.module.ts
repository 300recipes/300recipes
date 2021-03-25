import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainToolbarModule } from "../modules/main-toolbar/main-toolbar.module";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MainModule } from "../modules/main/main.module";
import { ReceiptModule } from "../modules/receipt/receipt.module";
import { CommonModule } from "@angular/common";
import { AdminModule } from 'src/modules/admin/admin.module';



@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    MainToolbarModule,
    MainModule,
    NgbModule,
    ReceiptModule,
    AdminModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
