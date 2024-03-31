import { Component } from '@angular/core';

@Component({
  selector: 'app-ex4',
  templateUrl: './ex4.component.html',
  styleUrls: ['./ex4.component.css']
})
export class Ex4Component {
  numbers: number[] = [];

  onIntervalFire(number: number) {
    this.numbers.push(number);
  }

  getOdd() {
    let odds: number[] = []
    for (let n of this.numbers) {
      if (n % 2 !== 0) {
        odds.push(n)
      }
    }
    return odds
  }

  getEven() {
    let evens: number[] = []
    for (let n of this.numbers) {
      if (n % 2 === 0) {
        evens.push(n)
      }
    }
    return evens
  }
}
