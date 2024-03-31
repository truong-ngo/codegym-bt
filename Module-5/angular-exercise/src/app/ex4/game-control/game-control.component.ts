import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-game-control',
  templateUrl: './game-control.component.html',
  styleUrls: ['./game-control.component.css']
})
export class GameControlComponent {
  @Output() intervalFired = new EventEmitter<number>();
  interval;
  lastNumber = 1;
  isStartDisable = false;
  isPauseDisable = true;

  onStartGame() {
    this.interval = setInterval(() => {
      this.intervalFired.emit(this.lastNumber);
      this.lastNumber++;
      this.isStartDisable = true;
      this.isPauseDisable = false;
    },1000)
  }

  onPauseGame() {
    clearInterval(this.interval)
    this.isStartDisable = false;
    this.isPauseDisable = true;
  }
}
