import { Component } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent {
  screenContent = '';

  onTypeButton(btn: string) {
    this.screenContent += btn;
  }

  clearScreen() {
    this.screenContent = '';
  }

  calculate() {
    this.screenContent = eval(this.screenContent);
  }


}
