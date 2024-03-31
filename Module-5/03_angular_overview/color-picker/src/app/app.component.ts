import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'color-picker';
  myColor = ''

  changeColor(event: Event) {
    this.myColor = (<HTMLInputElement>event.target).value;
  }
}
