import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MainPageComponent} from "../modules/main/components/main-page/main-page.component";
import {ReceiptPageComponent} from "../modules/receipt/receipt-page/receipt-page.component";


const routes: Routes = [
  { path: '',   redirectTo: '/receipts', pathMatch: 'full' },
  { path: 'receipts', children: [
      { path: '', component: MainPageComponent, pathMatch: 'full'},
      { path: ':id', component: ReceiptPageComponent},
    ]
  },
  // TODO: {path: "**", component: 404 }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
