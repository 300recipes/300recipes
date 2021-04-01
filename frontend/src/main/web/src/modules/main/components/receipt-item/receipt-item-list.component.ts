import { Component, Input, OnInit } from '@angular/core';
import { ReceiptService } from 'src/modules/core/services/receipt.service';
import { Receipt } from "../../../core/models/receipt.model";

@Component({
  selector: 'app-receipt-list-item',
  templateUrl: './receipt-item-list.component.html',
  styleUrls: ['./receipt-item-list.component.css']
})
export class ReceiptItemListComponent {
  @Input() public receipt: Receipt;

  constructor(private receiptService: ReceiptService) {
  }

  like() {
    this.receiptService.setLike(this.receipt)
  }

  dislike() {
    this.receiptService.setDislike(this.receipt)
  }
}
