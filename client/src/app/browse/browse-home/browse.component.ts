import { Component, OnInit } from '@angular/core';
import { GetCurrenciesService } from '../../get-currencies.service'

@Component({
  selector: 'app-browse',
  templateUrl: './browse.component.html',
  styleUrls: ['./browse.component.css']
})
export class BrowseComponent implements OnInit {

  currencies: any;

  constructor(private getCurrenciesService: GetCurrenciesService) {
   }

  getSearchedCurrency() {
    console.log('inside getSearchedCurrency()')
  }

  resetCurrencySearch() {
    console.log('inside resetCurrencySearch()')
  }

  currencySearch() {
    console.log('inside currencySearch');
    this.getCurrenciesService.getCurrencies().subscribe((response) => {
      console.log(response);
    })
  }


  ngOnInit() { }

}


