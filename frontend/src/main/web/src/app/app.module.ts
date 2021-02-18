import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainToolbarModule } from "../modules/main-toolbar/main-toolbar.module";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {MainModule} from "../modules/landing/main.module";



@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MainToolbarModule,
    MainModule,
    NgbModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
