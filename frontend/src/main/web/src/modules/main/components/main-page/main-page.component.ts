import { Component, OnInit } from '@angular/core';
import {ReceiptService} from "../../../core/services/receipt.service";
import {Observable} from "rxjs";
import {Receipt, SearchReceipt} from "../../../core/models/receipt.model";

@Component({
  selector: 'app-landing-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})

export class MainPageComponent implements OnInit {
  // tslint:disable-next-line:variable-name
  public _receiptList$: Observable<Receipt[]> = this.receiptService.getReceiptList();

  public receipts: Receipt[] = [];

  public searchQuery = '';

  constructor(private receiptService: ReceiptService) { }

  ngOnInit(): void {
    this.receiptService.getReceiptList().subscribe(data => {
      this.receipts = data;
    });
  }

  public search(s: SearchReceipt): void {
    console.log(s);
    console.log("--");



    this.receiptService.getReceiptList().subscribe(data => {
      this.receipts = data;
    });
  }
}
