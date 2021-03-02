import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { AuthenticationService } from 'src/modules/core/services/authentication.service';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  isSent: boolean;
  loading: boolean;
  username = '';
  email = '';
  password = '';
  confirmPassword = '';
  firstName = '';
  lastName = '';
  message: string;

  constructor(public activeModal: NgbActiveModal,
    private authenticationService: AuthenticationService,) { }

  ngOnInit(): void {
    this.isSent = false;
    this.loading = false;
  }

  signUp() {
    if (!this.username) {
      this.message = "Введіть ваш логін!";
      return;
    }
    if (!this.firstName) {
      this.message = "Введіть ваше ім'я!";
      return;
    }
    if (!this.lastName) {
      this.message = "Введіть ваше прізвище!";
      return;
    }
    if (!this.email || !this.email.match(/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/)) {
      this.message = "Некоректна поштова адреса";
      return;
    }
    if (!this.password || this.password.length < 6) {
      this.message = "Пароль замалий, потрібно щонайменше 6 символів";
      return;
    }
    if (!this.password.match(/([a-zA-Z]+[0-9]+)|([0-9]+[a-zA-Z]+)/)) {
      this.message = "Пароль може містити тільки літери латинського алфафіту та цифри";
      return;
    }
    if (this.password !== this.confirmPassword) {
      this.message = "Паролі не співпадають";
      return;
    }
     this.authenticationService.signupUser(this.username, this.email, this.password, this.firstName, this.lastName).pipe(first())
       .subscribe(n => {
         if (n) {
           this.isSent = true;
           this.activeModal.close();
         }
       },
         error => {
           this.message = error.error ? error.error.message : "Сталася помилка! Спробуйте ще раз!";
           console.log(error);
           this.loading = false;
         }
       );
    this.loading = true;
  }


}
