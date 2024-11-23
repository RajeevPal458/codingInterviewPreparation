import { CurrencyPipe } from "@angular/common";
import { Pipe, PipeTransform } from "@angular/core";



@Pipe({
        name:"mycurrency",
        standalone:true
})
export class CurrencyCutomPipe implements PipeTransform{

    transform(value: number, ...args: any[]):string {
        const [param] = args
        const currencyType = param[0];
        const currencyValue = parseInt(param[1]);
        console.log("console log "+param+'   '+currencyType+' '+currencyValue);
        const total= value*currencyValue;
        return total+' '+currencyType;
    }
}