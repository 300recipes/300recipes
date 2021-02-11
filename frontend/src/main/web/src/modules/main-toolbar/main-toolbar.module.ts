import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainToolbarComponent } from './main-toolbar.component';



@NgModule({
  declarations: [MainToolbarComponent],
  imports: [
    CommonModule,
  ],
  exports: [
    MainToolbarComponent
  ]
})
export class MainToolbarModule { }
