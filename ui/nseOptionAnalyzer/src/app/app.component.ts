import { Component } from '@angular/core';
import { Color, ScaleType } from '@swimlane/ngx-charts';
import { DerivativeModel } from 'src/model/derivative.model';
import { ChartSeries, OptionChainChart } from 'src/model/optionchain-chart.model';
import { OptionChainService } from 'src/service/optionchain.service';

@Component({
   selector: 'app-root',
   templateUrl: './app.component.html',
   styleUrls: ['./app.component.less']
})
export class AppComponent {
   derivativeModel: DerivativeModel[] = [];
   chartData: OptionChainChart[] = [];
   loadChart: boolean = false;
   constructor(private optionChainServicle: OptionChainService) { }

   ngOnInit() {
      this.optionChainServicle.getAll().subscribe(res => {
         this.derivativeModel = res;
         const series: ChartSeries[] = [];
         res.forEach(model => {
            series.push(new ChartSeries(model.time, model.diff));
         });
         this.chartData.push(new OptionChainChart("DIFF", series));
         this.loadChart = true;
      }); 
   }

   title = 'nseOptionAnalyzer';

}
