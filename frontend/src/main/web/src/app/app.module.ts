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
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { JwtInterceptor } from 'src/modules/core/utils/jwt.interceptor';
import { CoreModule } from 'src/modules/core/core.module';



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
    AdminModule,
    CoreModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
