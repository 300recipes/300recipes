import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { tap } from 'rxjs/operators';
import { ApproveService } from 'src/modules/core/services/approve.service';

@Component({
  selector: 'app-approve-receipt',
  templateUrl: './approve-receipt.component.html',
  styleUrls: ['./approve-receipt.component.css']
})
export class ApproveReceiptComponent implements OnInit {

  private receiptId: string;

  constructor(
    private approveService: ApproveService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.receiptId = this.route.snapshot.paramMap.get('id');
  }

  approve(): void {
    console.log(this.receiptId);
    this.approveService.approveRecipe(this.receiptId).subscribe();
  }

}
