import {Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-create-receipt-page',
  templateUrl: './create-receipt-page.component.html',
  styleUrls: ['./create-receipt-page.component.css']
})
export class CreateReceiptPageComponent implements OnInit {

  public receiptForm: FormGroup;

  public ingredients = [
    'sugar',
    'salt',
  ];

  constructor(private formBuilder: FormBuilder,) {
  }

  get ingredientsForm(): FormArray {
    return this.receiptForm.get('ingredients') as FormArray;
  }

  get stepsForm(): FormArray {
    return this.receiptForm.get('steps') as FormArray;
  }

  ngOnInit(): void {
    this.receiptForm = this.formBuilder.group({
      title: new FormControl('dfgdg', Validators.required),
      description: new FormControl('gf', Validators.required),
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
    // }
  }
}
