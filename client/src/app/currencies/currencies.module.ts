import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CurrenciesRoutingModule } from './currencies-routing.module';
import { CurrenciesHomeComponent } from './currencies-home/currencies-home.component';


@NgModule({
  declarations: [CurrenciesHomeComponent],
  imports: [
    CommonModule,
    CurrenciesRoutingModule
  ]
})
export class CurrenciesModule { }
