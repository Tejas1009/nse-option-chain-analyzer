import { Component, OnInit } from '@angular/core';
import { Color, ScaleType } from '@swimlane/ngx-charts';
import { OptionChainChart } from 'src/model/optionchain-chart.model';
import { Input } from '@angular/core';

@Component({
  selector: 'app-optionchain-chart',
  templateUrl: './optionchain-chart.component.html',
  styleUrls: ['./optionchain-chart.component.less']
})
export class OptionchainChartComponent implements OnInit {
  @Input() chartData: OptionChainChart[] = [];
  view: any[] = [700, 300];
  legend: boolean = true;
  showLabels: boolean = true;
  animations: boolean = true;
  xAxis: boolean = true;
  yAxis: boolean = true;
  showYAxisLabel: boolean = true;
  showXAxisLabel: boolean = true;
  xAxisLabel: string = 'Time';
  yAxisLabel: string = 'Diff';
  timeline: boolean = true;
  colorScheme: Color = {
     name: "nifty",
     selectable: false,
     group: ScaleType.Time,
     domain: ['#5AA454']
  };
  constructor() { }

  ngOnInit(): void {
  }

}
