import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ex-2';
  username = "";

  constructor() {
  }

  checkEmpty() {
    return this.username === "";
  }

  resetUsername() {
    this.username = "";
  }
}
