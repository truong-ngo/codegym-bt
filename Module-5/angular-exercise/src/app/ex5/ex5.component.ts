import {Component, EventEmitter} from '@angular/core';
import {Switch} from "./switch.service";

@Component({
  selector: 'app-ex5',
  templateUrl: './ex5.component.html',
  styleUrls: ['./ex5.component.css'],
  providers: [Switch]
})
export class Ex5Component {
  constructor(public switchService: Switch) {

  }
}
