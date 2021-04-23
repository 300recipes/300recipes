import { Component, OnInit } from '@angular/core';

import { NgbModal, ModalDismissReasons, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { first } from 'rxjs/operators';
import { AuthenticationService } from 'src/modules/core/services/authentication.service';
import { ToastsService } from 'src/modules/core/services/toasts.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  username = '';
  password = '';


  constructor(public activeModal: NgbActiveModal,
    private authenticationService: AuthenticationService,
    private toastService: ToastsService) { }

  ngOnInit(): void {
  }

  logIn() {
    this.authenticationService.signinUser(this.username, this.password)
      .subscribe(
        () => {
          this.toastService.showSuccess("Signed in")
        },
        error => {
          this.toastService.showDanger("Signing in failed ")
          console.log(error)
        }
      );
    this.activeModal.close('Close click');
  }

}
