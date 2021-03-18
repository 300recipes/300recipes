import {Component, EventEmitter, HostListener, Input, OnInit, Output} from '@angular/core';
import {ReceiptService} from '../../../core/services/receipt.service';

export interface DropdownItem {
  id: string;
  label: string;
}

@Component({
  selector: 'app-dropdown',
  templateUrl: './dropdown.component.html',
  styleUrls: ['./dropdown.component.css']
})
export class DropdownComponent {

  @Input() public width = 250;
  @Input() public label = 'Select item:';
  @Input() public items: DropdownItem[] = [];

  @Output() public selectedItem = new EventEmitter<DropdownItem>();

  public selected: DropdownItem;
  public opened = false;
  private wasInside = false;

  public itemClicked(item: DropdownItem) {
    this.selectedItem.emit(item);
    this.selected = item;
    this.opened = false;
  }

  @HostListener('click')
  clickInside() {
    this.wasInside = true;
  }

  @HostListener('document:click')
  clickout() {
    if (!this.wasInside) {
      this.opened = false;
    }
    this.wasInside = false;
  }
}
