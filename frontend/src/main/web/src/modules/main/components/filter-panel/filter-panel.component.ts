import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ReceiptService} from "../../../core/services/receipt.service";
import {Category, Ingredient, SearchReceipt} from "../../../core/models/receipt.model";
import {DropdownItem} from "../dropdown/dropdown.component";

@Component({
  selector: 'app-filter-panel',
  templateUrl: './filter-panel.component.html',
  styleUrls: ['./filter-panel.component.css']
})
export class FilterPanelComponent implements OnInit {

  // TODO: fix styles
  // TODO: fix id (not coming from backend)
  constructor(private receiptService: ReceiptService) { }

  public term = '';

  public ingredients: DropdownItem[] = [];
  public selectedIngredients: DropdownItem[] = [];

  public categories: DropdownItem[] = [];
  public selectedCategories: DropdownItem[] = [];

  @Output() onSearch = new EventEmitter<SearchReceipt>();

  ngOnInit(): void {
    this.receiptService.getIngredientsList().subscribe(ingredients => {
      this.ingredients = ingredients.map(
        ingredient => ({id: ingredient.id, label: ingredient.name}));
    });
    this.receiptService.getCategoriesList().subscribe(categories => {
      this.categories = categories.map(
        category => ({id: category.id, label: category.name}));
    });
  }

  getAvailableIngredients(): DropdownItem[] {
    return this.ingredients.filter(
      ing => !this.selectedIngredients.find(s => s.label === ing.label));
  }

  selectIngredient(item: DropdownItem): void {
    this.selectedIngredients.push(item);
    console.log(this.selectedIngredients);
    console.log(this.ingredients);
  }

  getAvailableCategories(): DropdownItem[] {
    return this.categories.filter(
      ing => !this.selectedCategories.find(s => s.id === ing.id));
  }

  selectCategory(item: DropdownItem): void {
    this.selectedCategories.push(item);
  }

  removeIngredient(item: DropdownItem): void {
    this.selectedIngredients = this.selectedIngredients.filter(sel => sel.label !== item.label);
  }

  removeCategory(item: DropdownItem): void {
    this.selectedCategories = this.selectedCategories.filter(sel => sel.label !== item.label);
  }

  public search() {
    const searchQuery: SearchReceipt = {
      query: this.term || null,
      category: (this.selectedCategories && this.selectedCategories.length) ?
        this.selectedCategories.map(s => s.id) : null,
      ingredients: (this.selectedIngredients && this.selectedIngredients.length) ?
        this.selectedIngredients.map(s => s.id) : null,
    };
    this.onSearch.emit(searchQuery);
  }
}
