import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NgxChartsModule }from '@swimlane/ngx-charts';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { OptionChainService } from 'src/service/optionchain.service';
import { HttpClientModule } from '@angular/common/http';
import { OptionchainChartComponent } from './optionchain-chart/optionchain-chart.component';

@NgModule({
  declarations: [
    AppComponent,
    OptionchainChartComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    NgxChartsModule,
    HttpClientModule
  ],
  providers: [OptionChainService],
  bootstrap: [AppComponent]
})
export class AppModule { }