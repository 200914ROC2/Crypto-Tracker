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
    this.getCurrenciesService.getSearchedCurrency().subscribe((response) => {
      this.singleCurrency = response;
      console.log(this.singleCurrency);
    })
  }

  resetCurrencySearch() {
    console.log('inside resetCurrencySearch()')
    console.log('filterText before: ' + this.filterText);
    this.filterText = null;
    console.log('filterText after: ' + this.filterText);
  }

  currencySearch() {
    console.log('inside currencySearch');
    this.singleCurrency = this.getCurrenciesService.getCurrencies().subscribe((response) => {
      this.currencies = response;
      console.log(response);
    })
  }


  ngOnInit() {
    // this.currencySearch();
  }

}


