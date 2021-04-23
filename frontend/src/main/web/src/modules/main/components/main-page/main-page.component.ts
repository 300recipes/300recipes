import { Component, OnInit } from '@angular/core';
import { ReceiptService } from '../../../core/services/receipt.service';
import { Receipt, SearchReceipt } from '../../../core/models/receipt.model';
import { DropdownItem } from '../dropdown/dropdown.component';

@Component({
  selector: 'app-landing-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})

export class MainPageComponent implements OnInit {
  // tslint:disable-next-line:variable-name
  // public _receiptList$: Observable<Receipt[]> = this.receiptService.getReceiptList();

  public receipts: Receipt[] = [];

  public sortedReceipts: Receipt[] = [];

  public searchQuery = '';

  public sortOptions: DropdownItem[] = [
    {
      id: 'name',
      label: 'name',
    },
    {
      id: 'author',
      label: 'author',
    }
  ];

  public dropdownLabel = 'name';
  public ascending = true;

  constructor(private receiptService: ReceiptService) {
  }

  ngOnInit(): void {
    this.receiptService.getReceiptList().subscribe(data => {
      this.receipts = data;
      this.sortedReceipts = this.receipts;

      this.selectSort(this.sortOptions[0]);
    });
  }

  public changeDirection() {
    this.ascending = !this.ascending;
    this.sortedReceipts.reverse();
  }

  public selectSort(sort: DropdownItem) {
    if (sort.id === 'name') {
      this.sortedReceipts = this.receipts;
      this.sortedReceipts = this.sortedReceipts.sort(
        (a, b) => a.title.toLocaleLowerCase().localeCompare(b.title.toLocaleLowerCase()));
    } else if (sort.id === 'author') {
      this.sortedReceipts = this.receipts;
      this.sortedReceipts = this.sortedReceipts.sort(
        (a, b) => a.author.toLocaleLowerCase().localeCompare(b.author.toLocaleLowerCase()));
    }
    if (!this.ascending) {
      this.sortedReceipts.reverse();
    }
    this.dropdownLabel = sort.label;
  }

  public search(s: SearchReceipt): void {
    // console.log(s);
    // console.log(' -- search');
    this.receiptService.searchReceipts(s).subscribe(data => {
      // console.log(data);
      // console.log('hmm');
      this.receipts = data;
      this.sortedReceipts = this.receipts;
    });
  }
}
