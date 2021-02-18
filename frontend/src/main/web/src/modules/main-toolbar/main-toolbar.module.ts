import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainToolbarComponent } from './main-toolbar/main-toolbar.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';



@NgModule({
  declarations: [MainToolbarComponent, SignInComponent, SignUpComponent],
  imports: [
    CommonModule,
  ],
  exports: [
    MainToolbarComponent
  ]
})
export class MainToolbarModule { }
