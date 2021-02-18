import { Component, OnInit } from '@angular/core';

import {NgbModal, ModalDismissReasons, NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  username = '';
  password = '';


  constructor(public activeModal: NgbActiveModal) { }

  ngOnInit(): void {
  }

  logIn(){
    
  }

}
