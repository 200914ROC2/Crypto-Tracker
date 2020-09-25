import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class GetCurrenciesService {

  accesskey: '25beef7fd94a2f8063ebd8a1d884d5bd5c723f307ddb49cdadd7ec62bc695b99';

  constructor(private http: HttpClient) {}

  getCurrencies() {
    return this.http.get('https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=USD,JPY,EUR', {
      headers: {
        Authorization: 'Apikey 25beef7fd94a2f8063ebd8a1d884d5bd5c723f307ddb49cdadd7ec62bc695b99'
      }
    })
  }

}

