import { Component, OnInit } from '@angular/core';
import { GetCurrenciesService } from '../../get-currencies.service'

@Component({
  selector: 'app-browse',
  templateUrl: './browse.component.html',
  styleUrls: ['./browse.component.css']
})
export class BrowseComponent implements OnInit {

  currencies;
  filteredCurrencies;
  singleCurrency;
  filterText: string;
  logoUrl;
  price;

  constructor(private getCurrenciesService: GetCurrenciesService) {
  }

  filterCurrencies(filterText: string) {
    console.log('inside filterCurrencies');
    this.filteredCurrencies = this.currencies;
    this.filterText = filterText;
    console.log(this.filterText);
  }

  getSearchedCurrency() {
    console.log('inside getSearchedCurrency()');
    this.filterText = this.filterText.toUpperCase();
    this.getCurrenciesService.getSearchedCurrency(this.filterText).subscribe((response) => {
      this.singleCurrency = response;
      this.price = this.singleCurrency.RAW[this.filterText].USD.PRICE;
      this.logoUrl = 'https://cryptocompare.com' + this.singleCurrency.RAW[this.filterText].USD.IMAGEURL;
      console.log(this.singleCurrency.RAW[this.filterText].USD);
    })
  }

  resetCurrencySearch() {
    console.log('inside resetCurrencySearch()')
    console.log('filterText before: ' + this.filterText);
    this.filterText = null;
    console.log('filterText after: ' + this.filterText);
  }

  getCurrencies() {
    console.log('inside currencySearch');
    this.singleCurrency = this.getCurrenciesService.getCurrencies().subscribe((response: any) => {
      this.currencies = response.Data;
      console.log(response);
    })
  }


  ngOnInit() {
    // this.currencySearch();
  }

}


