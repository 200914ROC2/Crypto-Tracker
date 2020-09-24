import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-input',
  templateUrl: './input.component.html',
  styleUrls: ['./input.component.css']
})
export class InputComponent implements OnInit {
  @Input() handleChange = null;

  constructor() { }

  onChange(event) {
    event.preventDefault();
    this.handleChange(event.target.value);
  }

  ngOnInit(): void {
  }

}
