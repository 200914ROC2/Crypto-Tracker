import { Component, OnInit } from '@angular/core';

import { GetCurrenciesService } from '../../get-currencies.service'

@Component({
  selector: 'app-portfolio',
  templateUrl: './portfolio.component.html',
  styleUrls: ['./portfolio.component.css']
})
export class PortfolioComponent implements OnInit {

  constructor(private getCurrenciesService: GetCurrenciesService) {
  }

  ngOnInit(): void {
    this.getCurrenciesService.getPortfolio();
  }

  getPortfolio(id) {

  }

}
