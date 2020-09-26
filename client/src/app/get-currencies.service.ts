import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class GetCurrenciesService {

  accesskey: '25beef7fd94a2f8063ebd8a1d884d5bd5c723f307ddb49cdadd7ec62bc695b99';

  // url for full search: https://min-api.cryptocompare.com/data/top/totalvolfull?limit=20&tsym=USD
  // url for individual search: https://min-api.cryptocompare.com/data/pricemultifull?fsyms=BTC&tsyms=USD

  // url for icon search: https://www.cryptocompare.com/media/*

  constructor(private http: HttpClient) {}

  getCurrencies() {
    return this.http.get('https://min-api.cryptocompare.com/data/top/totalvolfull?limit=20&tsym=USD')
  }

  getSearchedCurrency() {
    return this.http.get('https://min-api.cryptocompare.com/data/pricemultifull?fsyms=BTC&tsyms=USD')
  }

}

