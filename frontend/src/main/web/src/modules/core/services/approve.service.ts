import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';

import { Receipt } from '../models/receipt.model';

@Injectable({
  providedIn: 'root'
})
export class ApproveService {
  private url = 'https://recipes300.herokuapp.com/api/';

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      observe: 'response'
    })
  };
  constructor(private http: HttpClient) { }

  public getReceiptListForApprove(): Observable<Receipt[]> {
    // TODO change link from /recipes to /approve or similar after backend is connected 
    return this.http.get<Receipt[]>(this.url + 'recipes');
  }

  public approveRecipe(id: String): any {
    // TODO change it
    return this.http.post(this.url + 'recipes/approve', JSON.stringify({ "id": id }), this.httpOptions).pipe(
      map(data => console.log(JSON.stringify(data)))
    );
  }
}
