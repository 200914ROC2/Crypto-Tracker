import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomeHomeComponent } from './home-home/home-home.component';
import { BrowseModule } from '../browse/browse.module';
import { CurrencyDetailsModule } from '../currency-details/currency-details.module';



@NgModule({
  declarations: [HomeHomeComponent],
  imports: [
    CommonModule,
    HomeRoutingModule,
    BrowseModule,
    CurrencyDetailsModule
  ]
})
export class HomeModule { }
