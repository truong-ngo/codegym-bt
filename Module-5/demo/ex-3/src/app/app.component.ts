import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ex-3';
  message = 'You got message'
  clickDetails = [];
  countClick = 0;
  messStatus = true

  onToggleDetail() {
    this.messStatus = !this.messStatus;
    this.countClick++;
    this.clickDetails.push({
      "count": this.countClick,
      "className": this.getClass(),
      "date": new Date().toDateString()
    });
  }

  getClass() {
    return (this.countClick >= 5) ? 'active' : '';
  }
}


