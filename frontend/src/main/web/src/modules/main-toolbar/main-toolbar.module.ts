import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainToolbarComponent } from './main-toolbar/main-toolbar.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [MainToolbarComponent, SignInComponent, SignUpComponent],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule
  ],
  exports: [
    MainToolbarComponent
  ]
})
export class MainToolbarModule { }
