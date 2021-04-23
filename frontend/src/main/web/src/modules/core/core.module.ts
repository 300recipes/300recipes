import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ToastsContainer } from './components/toast-container/toast-container.component';
import { NgbToastModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    ToastsContainer
  ],
  exports: [ToastsContainer],
  imports: [
    CommonModule,
    NgbToastModule,

  ]
})
export class CoreModule { }
