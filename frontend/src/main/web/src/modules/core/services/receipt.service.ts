import { Injectable } from '@angular/core';
import { Observable, of } from "rxjs";

import { Category, Ingredient, Receipt, SearchReceipt } from "../models/receipt.model";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { map } from "rxjs/operators";
import {applySourceSpanToExpressionIfNeeded} from "@angular/compiler/src/output/output_ast";


@Injectable({
  providedIn: 'root'
})
export class ReceiptService {

  private url = 'https://recipes300.herokuapp.com/';
  private localUrl = 'http://localhost:8083/';

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      observe: 'response'
    })
  };

  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  // delete after backend is connected
  private stubReceipts: Receipt[] = [
  ];


  constructor(private http: HttpClient) {
  }

  // TODO: from, quantity
  public getReceiptList(): Observable<Receipt[]> {
    return this.http.get<Receipt[]>(this.localUrl + 'api/recipes');
  }

  public getStubReceipts(): Observable<Receipt[]> {
    return of(this.stubReceipts);
  }

  public getIngredientsList(): Observable<Ingredient[]> {
    return this.http.get<Ingredient[]>(this.url + 'api/ingredients');
  }

  public getCategoriesList(): Observable<Category[]> {
    return this.http.get<Category[]>(this.url + 'api/categories');
  }

  public getStubReceipt(id: string): Observable<Receipt> {
    return of(this.stubReceipts.find(receipt => receipt.id === id));
  }

  public getReceipt(id: string): Observable<Receipt> {
    return this.http.get<Receipt>(this.url + 'api/recipe/' + id);
  }

  public searchRecipes(value: string): Observable<Receipt[]> {
    return this.http.get<Receipt[]>(this.localUrl + 'api/recipes/search/' + value);
  }

  public addRecipe(receipt: unknown): any {
    // this.http.post(this.url + 'api/recipes/add', receipt);


    console.log(JSON.stringify(receipt));

    return this.http.post(this.localUrl + 'api/recipes/add', JSON.stringify(receipt), this.httpOptions).pipe(
      map(data => {
        console.log(JSON.stringify(data));
        alert(JSON.stringify(data));
        return data;
      })
    );
  }

  public searchReceipts(search: SearchReceipt): any {
    // console.log('search' + search);
    // TODO: replace url for searching recipies
    return this.http.post(this.url + 'api/recipes/filter', JSON.stringify(search), this.httpOptions).pipe(
      map(data => {
        console.log(JSON.stringify(data));
        return data;
      }
      ));
  }

  public setLike(receipt: Receipt) {
    window.alert("LIKE " + receipt.title)

    this.http.post(this.localUrl + 'api/recipe/like/'+ receipt.id, this.httpOptions).subscribe();
  }

  public setDislike(receipt: Receipt) {
    window.alert("DISLIKE " + receipt.title)
    this.http.post(this.localUrl + 'api/recipe/dislike/'+ receipt.id, this.httpOptions).subscribe();
  }

  // Gets called when the user clicks on submit to upload the image
  public onUpload(selectedFile: File ): void {
    console.log(selectedFile);
    // FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    const uploadImageData = new FormData();
    uploadImageData.append('imageFile', selectedFile, selectedFile.name);
    console.log(uploadImageData);
    // Make a call to the Spring Boot Application to save the image
    this.http.post('http://localhost:8083/api/image/upload', uploadImageData, { observe: 'response' })
      .subscribe((response) => {
          if (response.status === 200) {
            alert( 'Image uploaded successfully');
          } else {
            alert( 'Image not uploaded successfully');
          }
        }
      );
  }

  // Gets called when the user clicks on retieve image button to get the image from back end
  public getImage(imageName: string): any {
    // Make a call to Sprinf Boot to get the Image Bytes.
    this.http.get('http://localhost:8083/api/image/get/' + imageName)
      .subscribe(
        res => {
          this.retrieveResonse = res;
          this.base64Data = this.retrieveResonse.picByte;
          this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
        }
      );
    return this.retrievedImage;
  }


}
