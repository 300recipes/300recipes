import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AuthenticationService } from 'src/modules/core/services/authentication.service';
import { SignInComponent } from '../sign-in/sign-in.component';
import { SignUpComponent } from '../sign-up/sign-up.component';

@Component({
  selector: 'app-main-toolbar',
  templateUrl: './main-toolbar.component.html',
  styleUrls: ['./main-toolbar.component.css']
})
export class MainToolbarComponent implements OnInit {

  constructor(private modalService: NgbModal,
    private authenticationService: AuthenticationService) { }

  ngOnInit(): void {
  }
  openSignUp() {
    this.modalService.open(SignUpComponent, { size: "sm" });
  }

  openSignIn() {
    this.modalService.open(SignInComponent);
  }

  signOut(){
    localStorage.removeItem('userData');
  }

  show(){
    return this.authenticationService.currentUserValue;
  }

}
