import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CurrencyDetailsHomeComponent } from './currency-details-home/currency-details-home.component';
import { PlotModule } from '../plot/plot.module';



@NgModule({
  declarations: [CurrencyDetailsHomeComponent],
  imports: [
    CommonModule,
    PlotModule
  ],
  exports: [
    CurrencyDetailsHomeComponent
  ]
})
export class CurrencyDetailsModule { }
