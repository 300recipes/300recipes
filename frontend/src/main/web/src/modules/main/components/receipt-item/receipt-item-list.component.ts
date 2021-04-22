import { Component, Input, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/modules/core/services/authentication.service';
import { ReceiptService } from 'src/modules/core/services/receipt.service';
import { Receipt } from "../../../core/models/receipt.model";

@Component({
  selector: 'app-receipt-list-item',
  templateUrl: './receipt-item-list.component.html',
  styleUrls: ['./receipt-item-list.component.css']
})
export class ReceiptItemListComponent {
  @Input() public receipt: Receipt;
  constructor(private receiptService: ReceiptService,
    private authenticationService: AuthenticationService,
  ) {
  }

  like() {
    this.receiptService.setLike(this.receipt)
  }

  dislike() {
    this.receiptService.setDislike(this.receipt)
  }

  isUser() {
    const user = this.authenticationService.currentUserValue;
    if (user) {
      let role = user.sub.substring(user.sub.lastIndexOf(',') + 1);
      return role === 'R_USER';
    }

    return false;
  }
}
