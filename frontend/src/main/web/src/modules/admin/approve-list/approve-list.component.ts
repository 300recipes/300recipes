import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Receipt } from 'src/modules/core/models/receipt.model';
import { ApproveService } from 'src/modules/core/services/approve.service';

@Component({
  selector: 'app-approve-list',
  templateUrl: './approve-list.component.html',
  styleUrls: ['./approve-list.component.css']
})
export class ApproveListComponent implements OnInit {

  constructor(private approveServise: ApproveService) { }

  public _receiptList$: Observable<Receipt[]> = this.approveServise.getReceiptListForApprove();

  ngOnInit(): void {
  }

}
