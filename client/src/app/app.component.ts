import { OnInit } from '@angular/core';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  getAllCurrencyPrices() {
    // go get currency prices and make the cards
  }

  ngOnInit() {
    this.getAllCurrencyPrices();
  }
}
