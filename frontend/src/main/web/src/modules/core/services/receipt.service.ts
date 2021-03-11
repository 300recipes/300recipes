import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";
import {Ingredient, Receipt} from "../models/receipt.model";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ReceiptService {

  private url = 'https://recipes300.herokuapp.com/';

  // delete after backend is connected
  private stubReceipts: Receipt[] = [
    {
      id: "1",
      title: "Steak",
      description: "Rally tasty steaks",
      author: "Messi",
      // content: {
      //   ingredients: [
      //     {
      //       name: "steak",
      //       quantity: "2",
      //     },
      //     {
      //       name: "oli",
      //       quantity: "1",
      //     },
      //     {
      //       name: "salt",
      //       quantity: "1",
      //     },
      //     {
      //       name: "garlic",
      //       "quantity": "2",
      //     }
      //   ],
      //   steps: [
      //     "Spill the oil into the pan and put it on fire",
      //     "Chop the gralic and put it into the pan",
      //     "Chop the steaks and put the into the pan too",
      //     "Put salt and fry the steaks for a few minutes, and then turn it to the other side",
      //     "Profit"
      //   ],
      // },
      imageUrl: "https://eda.ru/img/eda/c620x415i/s2.eda.ru/StaticContent/Photos/120214122930/130729002219/p_O.jpg",
    },
    {
      id: "2",
      author: "Obama",
      title: "Fried eggs",
      description: "Really not bad description of receipt",
      // content: {
      //   ingredients: [
      //     {
      //       name: "Eggs",
      //       quantity: "3",
      //     },
      //     {
      //       name: "Oil",
      //       quantity: "1",
      //     },
      //     {
      //       name: "Salt",
      //       quantity: "1",
      //     },
      //   ],
      //   steps: [
      //     "Spill the oil into the pan and put it on fire",
      //     "Crack the eggs into the pan",
      //     "Put salt and fry them for 2-3 minutes",
      //   ],
      // },
      imageUrl: "https://img.povar.ru/main/f2/45/9f/54/yaichnica_obichnaya-384161.jpg",
    },
    {
      id: "3",
      author: "Gordon",
      title: "Receipt 3",
      description: "Really wonderful description of receipt",
      // content: {
      //   ingredients: [
      //     {
      //       name: "tomato",
      //       quantity: "3",
      //     },
      //     {
      //       name: "cucumber",
      //       quantity: "3",
      //     },
      //     {
      //       name: "salad",
      //       quantity: "1",
      //     },
      //   ],
      //   steps: [
      //     "Chop the ingredients",
      //     "Mix them",
      //     "Profit",
      //   ]
      // },
      imageUrl: "http://www.tarikasingh.com/wp-content/uploads/2016/07/easy-one-pot-rice-dish-tehri-or-taheri-from-uttar-pradesh.1024x1024.jpg",
    }
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
    return this.http.get<Receipt>(this.url + 'api/recipe/' +id);
  }

}
