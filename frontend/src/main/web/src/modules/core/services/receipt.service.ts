import { Injectable } from '@angular/core';
import { Observable, of } from "rxjs";

import { Category, Ingredient, Receipt, SearchReceipt } from "../models/receipt.model";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { map } from "rxjs/operators";


@Injectable({
  providedIn: 'root'
})
export class ReceiptService {

  private url = 'https://recipes300.herokuapp.com/';
  //private localUrl = 'http://localhost:8083/';

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

  public getCategoriesList(): Observable<Category[]> {
    return this.http.get<Category[]>(this.url + 'api/categories');
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

  public addRecipe(receipt: unknown): any {
    console.log(JSON.stringify(receipt));

    return this.http.post(this.url + 'api/recipes/add', JSON.stringify(receipt), this.httpOptions).pipe(
      map(data => {
        console.log(JSON.stringify(data));
        alert(JSON.stringify(data));
        return data;
      })
    );
  }

  public searchReceipts(search: SearchReceipt): any {
    return this.http.post(this.url + 'api/recipes/filter', JSON.stringify(search), this.httpOptions).pipe(
      map(data => {
        console.log(JSON.stringify(data));
        return data;
      }
      ));
  }

  public setLike(receipt: Receipt) {
    this.http.post(this.url + 'api/recipe/like/' + receipt.id, this.httpOptions).subscribe();
  }

  public setDislike(receipt: Receipt) {
    this.http.post(this.url + 'api/recipe/dislike/' + receipt.id, this.httpOptions).subscribe();
  }




}
