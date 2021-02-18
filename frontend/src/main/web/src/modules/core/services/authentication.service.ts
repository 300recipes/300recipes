import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import * as sha1 from 'js-sha1';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  public readonly PASSWORD_HASHING_ITERATIONS_AMOUNT = 5;

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      observe: 'response'
    })
  };

  private url = "";

  constructor(private http: HttpClient,
  ) { }

  /* POST: signup user */
  signupUser(username: string, email: string, password: string, firstName: string, lastName: string): any {
    const userInfo = {
      username,
      password: this.passwordHashing(password, this.PASSWORD_HASHING_ITERATIONS_AMOUNT),
      email,
      firstName,
      lastName
    };
    return this.http.post(this.url + 'sign-up', JSON.stringify(userInfo), this.httpOptions);
  }

  passwordHashing(password: string, iterations?: number) {
    let crypt = sha1(password);
    for (let i = 0; i < iterations; ++i) {
      crypt = sha1(crypt);
    }
    return crypt;
  }

}
