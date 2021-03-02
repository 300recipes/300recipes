import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import * as sha1 from 'js-sha1';
import { map } from 'rxjs/operators';

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

  private url = "http://localhost:8083/api/";

  constructor(private http: HttpClient) { }


  public get currentUserValue() {
    return localStorage.getItem('userData');
  }



  /* POST: signup user */
  signupUser(username: string, email: string, password: string, firstName: string, lastName: string): any {
    const userInfo = {
      username,
      password,
      email,
      firstName,
      lastName
    };
    console.log(userInfo);
    return this.http.post(this.url + 'sign-up', JSON.stringify(userInfo), this.httpOptions);
  }

  passwordHashing(password: string, iterations?: number) {
    let crypt = sha1(password);
    for (let i = 0; i < iterations; ++i) {
      crypt = sha1(crypt);
    }
    return crypt;
  }

  signinUser(username: string, password: string): any {
    const userInfo = {
      username,
      password
    };

    //localStorage.setItem('userData', "token");
    console.log(userInfo);
    return this.http.post(this.url + 'login', JSON.stringify(userInfo), this.httpOptions).pipe(
        map(data => { localStorage.setItem('userData', JSON.stringify(data)) })
    );
  }

}
