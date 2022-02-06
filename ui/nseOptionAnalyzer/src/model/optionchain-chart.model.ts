export class OptionChainChart{
    constructor(public name: string, public series: ChartSeries[]){
    }
}

export class ChartSeries{
    constructor(public name: string, public value: number){}
}