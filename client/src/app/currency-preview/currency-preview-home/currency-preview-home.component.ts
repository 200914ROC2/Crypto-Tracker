import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-currency-preview-home',
  templateUrl: './currency-preview-home.component.html',
  styleUrls: ['./currency-preview-home.component.css']
})
export class CurrencyPreviewHomeComponent implements OnInit {
  @Input() name = "";
  @Input() symbol = "";
  @Input() imageUrl = "";
  @Input() price = "";

  @Output() clicked = new EventEmitter<string>();

  constructor() { }

  onClick(event: any) {
    event.preventDefault();
    this.clicked.emit(this.symbol);
  }

  ngOnInit(): void {
  }

}
