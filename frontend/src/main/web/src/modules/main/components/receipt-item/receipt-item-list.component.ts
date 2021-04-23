import { Component, Input, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/modules/core/services/authentication.service';
import { ReceiptService } from 'src/modules/core/services/receipt.service';
import { ToastsService } from 'src/modules/core/services/toasts.service';
import { Receipt } from "../../../core/models/receipt.model";

@Component({
  selector: 'app-receipt-list-item',
  templateUrl: './receipt-item-list.component.html',
  styleUrls: ['./receipt-item-list.component.css']
})
export class ReceiptItemListComponent {
  @Input() public receipt: Receipt;
  liked = false
  disliked = false
  constructor(private receiptService: ReceiptService,
    private authenticationService: AuthenticationService,
    private toastsService: ToastsService
  ) {
  }

  like() {
    if (!this.liked) {
      this.receiptService.setLike(this.receipt)
      this.toastsService.showSuccess(`You liked ${this.receipt.title}`)
      this.liked = true
    }
  }

  dislike() {
    if (!this.disliked) {
      this.receiptService.setDislike(this.receipt)
      this.toastsService.showDanger(`You disliked ${this.receipt.title}`)
      this.disliked = true
    }
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
