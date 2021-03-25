import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import * as sha1 from 'js-sha1';
import { map } from 'rxjs/operators';
import { BehaviorSubject } from 'rxjs';
import jwt_decode from 'jwt-decode';

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

  private url = "https://recipes300.herokuapp.com/api/";

  private currentUserSubject: BehaviorSubject<any>; 

  constructor(private http: HttpClient) { 
    this.currentUserSubject = new BehaviorSubject<any>(
      localStorage.getItem('userData') ? jwt_decode(localStorage.getItem('userData')) : undefined);
  }


  public get currentUserValue() {
    return this.currentUserSubject.value;
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
    return this.http.post(this.url + 'login', JSON.stringify(userInfo), this.httpOptions)
    .pipe(
        map(data => { 
          const tokenJSON: any = data.token;
          
          localStorage.setItem('userData', tokenJSON);
          const userDecode = jwt_decode(tokenJSON);
          this.currentUserSubject.next(userDecode);
          return userDecode;
        })
    );
  }

  signout(){
    localStorage.removeItem('userData');
    this.currentUserSubject.next(null);
  }

}


