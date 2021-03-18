import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";
import {Ingredient, Receipt} from "../models/receipt.model";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class ReceiptService {

  private url = 'https://recipes300.herokuapp.com/';

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      observe: 'response'
    })
  };
  // delete after backend is connected
  private stubReceipts: Receipt[] = [
  ];


  constructor(private http: HttpClient) {
  }

  // TODO: from, quantity
  public getReceiptList(): Observable<Receipt[]> {
    return this.http.get<Receipt[]>(this.url + 'api/recipes');
  }

  public getStubReceipts(): Observable<Receipt[]> {
    return of(this.stubReceipts);
  }

  public getIngredientsList(): Observable<Ingredient[]> {
    return this.http.get<Ingredient[]>(this.url + 'api/ingredients');
  }

  public getStubReceipt(id: string): Observable<Receipt> {
    return of(this.stubReceipts.find(receipt => receipt.id === id));
  }

  public getReceipt(id: string): Observable<Receipt> {
    return this.http.get<Receipt>(this.url + 'api/recipe/' + id);
  }

  public searchRecipes(value: string): Observable<Receipt[]> {
    return this.http.get<Receipt[]>(this.url + 'api/recipes/search/' + value);
  }

  public addRecipe(receipt: Receipt): any {
    this.http.post(this.url + 'api/recipes/add', receipt);
    console.log(receipt);
    return this.http.post(this.url + 'api/recipes/add', JSON.stringify(receipt), this.httpOptions).pipe(
      map(data => console.log(JSON.stringify(data)))
    );
  }

}
