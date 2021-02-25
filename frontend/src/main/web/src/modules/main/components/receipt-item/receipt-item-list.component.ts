import {Component, Input, OnInit} from '@angular/core';
import {Receipt} from "../../../core/models/receipt.model";

@Component({
  selector: 'app-receipt-list-item',
  templateUrl: './receipt-item-list.component.html',
  styleUrls: ['./receipt-item-list.component.css']
})
export class ReceiptItemListComponent {
  @Input() public receipt: Receipt;
}
