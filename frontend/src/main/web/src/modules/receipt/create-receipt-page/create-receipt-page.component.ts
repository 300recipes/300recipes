import {Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {ReceiptService} from "../../core/services/receipt.service";
import {Observable} from "rxjs";
import {Category, Ingredient, Receipt} from "../../core/models/receipt.model";

@Component({
  selector: 'app-create-receipt-page',
  templateUrl: './create-receipt-page.component.html',
  styleUrls: ['./create-receipt-page.component.css']
})
export class CreateReceiptPageComponent implements OnInit {

  public receiptForm: FormGroup;

  public availableIngredients$: Observable<Ingredient[]>;
  public usedIngredients: Ingredient[] = [];

  public availableCategories$: Observable<Category[]>;

  constructor(private formBuilder: FormBuilder,
              private receiptService: ReceiptService) {
  }

  get ingredientsForm(): FormArray {
    return this.receiptForm.get('ingredients') as FormArray;
  }

  get categoriesForm(): FormArray {
    return this.receiptForm.get('categories') as FormArray;
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

    this.availableCategories$ = this.receiptService.getCategoriesList();


    this.receiptForm = this.formBuilder.group({
      title: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
      imageUrl: new FormControl('', Validators.required),
      ingredients: this.formBuilder.array([]),
      steps: this.formBuilder.array([]),
      categories: this.formBuilder.array([]),
    });
    this.receiptForm.updateValueAndValidity();
  }

  public removeIngredient(i: number) {
    this.ingredientsForm.removeAt(i);
  }

  public removeStep(i: number) {
    this.stepsForm.removeAt(i);
  }

  public removeCategory(i: number) {
    this.categoriesForm.removeAt(i);
  }

  public addCategory() {
    this.categoriesForm.push(
      this.formBuilder.group({
        category: new FormControl(null),
      })
    );
    this.receiptForm.updateValueAndValidity();
    this.receiptForm.markAllAsTouched();
  }

  public addStep() {
    this.stepsForm.push(
      this.formBuilder.group({
        title: new FormControl('', Validators.required),
        description: new FormControl('', Validators.required),
        imageUrl: new FormControl(''),
      }));
    this.receiptForm.updateValueAndValidity();
  }

  public addIngredient() {
    this.ingredientsForm.push(
      this.formBuilder.group({
        amount: new FormControl(1, Validators.required),
        measure: new FormControl('', Validators.required),
        ingredient: new FormControl(null, Validators.required),
      }));
    this.receiptForm.updateValueAndValidity();
    this.receiptForm.markAllAsTouched();
  }

  public onSubmit() {
    if (this.receiptForm.valid) {
      const receipt = this.receiptForm.value;
      // console.log(receipt);


      const modified = {
        title: receipt.title,
        imageUrl: receipt.imageUrl,
        description: receipt.description,
        categories: receipt.categories.map((val: {category: Category}) => val.category.id) as any,
        steps: receipt.steps,
        ingredients: receipt.ingredients.map((val: {amount: number, measure: string , ingredient: Ingredient}) =>
          ({amount: val.amount, measure: val.measure , id: val.ingredient.id})),
      };

      // console.log(modified);

      this.receiptService.addRecipe(modified as any);
    }
  }

  selectedIngredient($event: Event) {
    console.log($event);
  }
}
