import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.css']
})
export class ButtonComponent implements OnInit {
  @Input() content = '';
  @Input() handleClick = null;

  constructor() { }

  onClick(event) {
    event.preventDefault();
    this.handleClick();
  }

  ngOnInit(): void {
  }
  
  // submitDateRange() {

  // }

  // submitRegistration() {

  // }

  // submitLogin() {

  // }

  // addToPortfolio() {

  // }

  // deleteFromPortfolio() {

  // }
}
