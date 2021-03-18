import {Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {ReceiptService} from "../../core/services/receipt.service";
import {Observable} from "rxjs";
import {Ingredient} from "../../core/models/receipt.model";
import {filter, map, tap} from "rxjs/operators";

@Component({
  selector: 'app-create-receipt-page',
  templateUrl: './create-receipt-page.component.html',
  styleUrls: ['./create-receipt-page.component.css']
})
export class CreateReceiptPageComponent implements OnInit {

  public receiptForm: FormGroup;

  // todo: get from api
  public availableIngredients$: Observable<Ingredient[]>;
  public usedIngredients: Ingredient[] = [];

  constructor(private formBuilder: FormBuilder,
              private receiptService: ReceiptService) {
  }

  get ingredientsForm(): FormArray {
    return this.receiptForm.get('ingredients') as FormArray;
  }

  get stepsForm(): FormArray {
    return this.receiptForm.get('steps') as FormArray;
  }

  ngOnInit(): void {

    this.availableIngredients$ = this.receiptService.getIngredientsList().pipe(
      /*map(ingredients => ingredients.filter(
        ingredient => !this.usedIngredients.find(used => used.name === ingredient.name)
      )),*/
    );

    this.receiptForm = this.formBuilder.group({
      title: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
      ingredients: this.formBuilder.array([]),
      steps: this.formBuilder.array([]),
    });
    this.receiptForm.updateValueAndValidity();
  }

  public removeIngredient(i: number) {
    this.ingredientsForm.removeAt(i);
  }

  public removeStep(i: number) {
    this.stepsForm.removeAt(i);
  }

  public addStep() {
    this.stepsForm.push(
      this.formBuilder.group({
        title: new FormControl('', Validators.required),
        description: new FormControl('', Validators.required),
        // todo: add image
      }));
    this.receiptForm.updateValueAndValidity();
  }

  public addIngredient() {
    this.ingredientsForm.push(
      this.formBuilder.group({
        quantity: new FormControl(1, Validators.required),
        ingredient: new FormControl(null, Validators.required),
      }));
    this.receiptForm.updateValueAndValidity();
    this.receiptForm.markAllAsTouched();
  }

  public onSubmit() {
    // if (this.receiptForm.valid) {
      console.log(this.receiptForm.value);
      // TODO: MAKE Recept from receiptForm and post
      // this.receiptService.addRecipe(this.receiptForm.value)
    // }
  }

  selectedIngredient($event: Event) {
    console.log($event);
  }
}
