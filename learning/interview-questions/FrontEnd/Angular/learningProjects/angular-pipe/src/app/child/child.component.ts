import { Component } from '@angular/core';
import { CurrencyPipe } from '@angular/common';
import { CurrencyCutomPipe } from '../pipes/currency.custompipe';

@Component({
  selector: 'app-child',
  standalone: true,
  imports: [CurrencyCutomPipe,CurrencyPipe],
  templateUrl: './child.component.html',
  styleUrl: './child.component.css'
})
export class ChildComponent {
  employeeName="Rajeev Pal";
  salary:number = 200;
  exchangeRate:number=84;
}
