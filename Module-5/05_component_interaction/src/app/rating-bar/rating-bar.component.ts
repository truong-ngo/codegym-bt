import { Component } from '@angular/core';

@Component({
  selector: 'app-rating-bar',
  templateUrl: './rating-bar.component.html',
  styleUrls: ['./rating-bar.component.css']
})
export class RatingBarComponent {
  max = 10;
  showRatingValue: any;
  ratingValue = 5;
  ratingUnits: any;

  calculate(max:number, ratingValue: number) {
    this.ratingUnits = Array.from({length: max},
      (_, index) => ({
        value: index + 1,
        active: index < ratingValue
      }));
  }

  reset() {

  }

  select(i: number) {

  }

  enter(i: number) {

  }
}
