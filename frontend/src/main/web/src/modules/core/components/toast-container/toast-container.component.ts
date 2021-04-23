import { Component, TemplateRef } from '@angular/core';
import { ToastsService } from '../../services/toasts.service';



@Component({
  selector: 'app-toasts',
  templateUrl: './toast-container.component.html',
  host: { '[class.ngb-toasts]': 'true' }
})
export class ToastsContainer {
  constructor(public toastService: ToastsService) { }

  isTemplate(toast) { return toast.textOrTpl instanceof TemplateRef; }
}
