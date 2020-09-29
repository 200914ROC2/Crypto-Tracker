import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-plot-home',
  templateUrl: './plot-home.component.html',
  styleUrls: ['./plot-home.component.css']
})
export class PlotHomeComponent implements OnInit {
  @Input() title = "";
  @Input() xArray = [];
  @Input() yArray = [];

  constructor() { }

  data = null;
  layout = null;
  graph = {
    data: null,
    layout: null
  };

  ngOnInit(): void {
    console.log(this.xArray);
    console.log(this.yArray);
    this.data = [{ x: this.xArray, y: this.yArray, type: 'scatter', mode: 'lines+points', marker: {color: 'red'} }];
    this.layout = {width: 1000, height: 500, title: this.title, yaxis: {tickformat: '$'}};
  }

}
