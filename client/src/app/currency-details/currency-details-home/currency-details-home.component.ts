import { Component, OnInit, Input } from '@angular/core';
import { GetCurrenciesService } from '../../get-currencies.service';
import * as moment from 'moment';

@Component({
  selector: 'app-currency-details-home',
  templateUrl: './currency-details-home.component.html',
  styleUrls: ['./currency-details-home.component.css']
})
export class CurrencyDetailsHomeComponent implements OnInit {
  @Input() symbol = "BTC";

  constructor(private getCurrenciesService: GetCurrenciesService) { }
  render24Hour: boolean = false;
  x24Hour: Array<string> = [];
  y24Hour: Array<number> = [];

  ngOnInit(): void {
    this.getCurrenciesService.get24HourData(this.symbol).subscribe((response: any) => {
      for (let data of response.Data.Data) {
        const date = moment.unix(data.time);
        console.log(date);
        this.x24Hour.push(date.format("YYYY-MM-DD kk:mm:ss"));
        this.y24Hour.push(data.close);
      }
      this.render24Hour = true;
    });
  }

}
