import { Component, OnInit } from '@angular/core';
import {ReceiptService} from "../../../core/services/receipt.service";
import {Observable} from "rxjs";
import {Receipt} from "../../../core/models/receipt.model";

@Component({
  selector: 'app-landing-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})

export class MainPageComponent {
  // tslint:disable-next-line:variable-name
  public _receiptList$: Observable<Receipt[]> = this.receiptService.getReceiptList();

  constructor(private receiptService: ReceiptService) { }
}
