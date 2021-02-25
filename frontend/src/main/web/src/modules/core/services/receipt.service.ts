import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";
import {Receipt} from "../models/receipt.model";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ReceiptService {

  // delete after backend is connected
  private stubReceipts: Receipt[] = [
    {
      id: "1",
      title: "Receipt 1",
      description: "Really cool description of receipt",
      author: "Messi",
    },
    {
      id: "2",
      author: "Obama",
      title: "Receipt 2",
      description: "Really not bad description of receipt",
    },
    {
      id: "3",
      author: "Gordon",
      title: "Receipt 3",
      description: "Really wonderful description of receipt",
      url: "http://www.tarikasingh.com/wp-content/uploads/2016/07/easy-one-pot-rice-dish-tehri-or-taheri-from-uttar-pradesh.1024x1024.jpg",
    }
  ];


  constructor(private http: HttpClient) {
  }

  // TODO: from, quantity
  // TODO: add url! + dont forget to change to this method in component
  public getReceiptList(): Observable<Receipt[]> {
    return this.http.get<Receipt[]>("");
  }

  public getStubReceipts(): Observable<Receipt[]> {
    return of(this.stubReceipts);
  }
}
