import { Component, OnInit } from '@angular/core';
import { ReceiptService } from "../../core/services/receipt.service";
import { ActivatedRoute } from "@angular/router";
import { Receipt } from "../../core/models/receipt.model";
import { Observable } from "rxjs";
import { flatMap, tap } from "rxjs/operators";

@Component({
  selector: 'app-receipt-page',
  templateUrl: './receipt-page.component.html',
  styleUrls: ['./receipt-page.component.css']
})
export class ReceiptPageComponent implements OnInit {

  private receiptId: string;
  public _receipt$: Observable<Receipt>;

  constructor(private receiptService: ReceiptService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this._receipt$ = this.route.params.pipe(
      tap((params: { id: string }) => this.receiptId = params.id),
      flatMap(val => this.receiptService.getReceipt(val.id))
    )
  }
}
