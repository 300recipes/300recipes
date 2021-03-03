import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MainPageComponent} from '../modules/main/components/main-page/main-page.component';
import {ReceiptPageComponent} from '../modules/receipt/receipt-page/receipt-page.component';
import {CreateReceiptPageComponent} from '../modules/receipt/create-receipt-page/create-receipt-page.component';


const routes: Routes = [
  {path: '', redirectTo: '/receipts', pathMatch: 'full'},
  {
    path: 'receipts', children: [
      {path: '', component: MainPageComponent, pathMatch: 'full'},
      {path: 'create', component: CreateReceiptPageComponent, pathMatch: 'full'},
      {path: ':id', component: ReceiptPageComponent},
    ]
  },
  // TODO: {path: "**", component: 404 }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
