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

  isAdmin(){
    const user = this.authenticationService.currentUserValue;
    if(user){
      let role = user.sub.substring(user.sub.lastIndexOf(',') + 1);
      return role === 'R_ADMIN'; 
    }

    return false;
  }

  isUser(){
    const user = this.authenticationService.currentUserValue;
    if(user){
      let role = user.sub.substring(user.sub.lastIndexOf(',') + 1);
      return role === 'R_USER'; 
    }

    return false;
  }


  show() {
    return this.authenticationService.currentUserValue;
  }
}
