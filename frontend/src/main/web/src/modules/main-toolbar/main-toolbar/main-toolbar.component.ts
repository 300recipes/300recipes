import {Component, Input} from '@angular/core';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {AuthenticationService} from 'src/modules/core/services/authentication.service';
import {SignInComponent} from '../sign-in/sign-in.component';
import {SignUpComponent} from '../sign-up/sign-up.component';
import {ReceiptService} from "../../core/services/receipt.service";

@Component({
  selector: 'app-main-toolbar',
  templateUrl: './main-toolbar.component.html',
  styleUrls: ['./main-toolbar.component.css']
})
export class MainToolbarComponent {

  @Input() term = '';

  constructor(private modalService: NgbModal,
              private authenticationService: AuthenticationService,
              private receiptService: ReceiptService,
              private router: Router) {
  }

  openSignUp() {
    this.modalService.open(SignUpComponent, {size: "sm"});
  }

  openSignIn() {
    this.modalService.open(SignInComponent);
  }

  signOut() {
    this.authenticationService.signout();
  }

  add() {

  }

  show() {
    return this.authenticationService.currentUserValue;
  }

  search() {

    // this.router.navigate(['/receipts'], { queryParams: { search: this.term }, queryParamsHandling: 'merge' });
  }

}
