import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  result = 0;
  constructor() {
  }

  ngOnInit(): void {
  }
  public calculator(num1: string, num2: string, cal: string) {
    const number1: number = parseInt(num1);
    const number2: number = parseInt(num2);
    switch (cal) {
      case '+':
        this.result = number1 + number2;
        break;
      case '-':
        this.result = number1 - number2;
        break;

      case '*':
        this.result = number1 * number2;
        break;

      case '/':
        this.result = number1 / number2;
        break;
    }
  }
}
