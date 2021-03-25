import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainPageComponent } from '../modules/main/components/main-page/main-page.component';
import { ReceiptPageComponent } from '../modules/receipt/receipt-page/receipt-page.component';
import { CreateReceiptPageComponent } from '../modules/receipt/create-receipt-page/create-receipt-page.component';
import { ApproveListComponent } from 'src/modules/admin/approve-list/approve-list.component';
import { ApproveReceiptComponent } from 'src/modules/admin/approve-receipt/approve-receipt.component';


const routes: Routes = [
  { path: '', redirectTo: '/receipts', pathMatch: 'full' },
  {
    path: 'receipts', children: [
      { path: '', component: MainPageComponent, pathMatch: 'full' },
      { path: 'create', component: CreateReceiptPageComponent, pathMatch: 'full' },
      { path: ':id', component: ReceiptPageComponent },
    ]
  },
  {
    path: 'approve', children: [
      { path: '', component: ApproveListComponent, pathMatch: 'full' },
      { path: ':id', component: ApproveReceiptComponent },
    ]
  }
  // TODO: {path: "**", component: 404 }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
