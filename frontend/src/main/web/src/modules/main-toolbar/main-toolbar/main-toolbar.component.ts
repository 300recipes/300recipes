import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AuthenticationService } from 'src/modules/core/services/authentication.service';
import { ReceiptService } from 'src/modules/core/services/receipt.service';
import { SignInComponent } from '../sign-in/sign-in.component';
import { SignUpComponent } from '../sign-up/sign-up.component';

@Component({
  selector: 'app-main-toolbar',
  templateUrl: './main-toolbar.component.html',
  styleUrls: ['./main-toolbar.component.css']
})
export class MainToolbarComponent {

  term: string;

  constructor(private modalService: NgbModal,
    private authenticationService: AuthenticationService,
    private router: Router) { }

  openSignUp() {
    this.modalService.open(SignUpComponent, { size: "sm" });
  }

  openSignIn() {
    this.modalService.open(SignInComponent);
  }

  signOut(){
    localStorage.removeItem('userData');
  }

  add(){

  }

  show(){
    return this.authenticationService.currentUserValue;
  }

  search(){
    this.router.navigate(['/receipts'], { queryParams: { search: this.term }, queryParamsHandling: 'merge' });
  }

}
