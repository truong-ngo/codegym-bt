import {Component, OnInit} from '@angular/core';
import {Switch} from "../switch.service";
import {Input} from "@angular/core";

@Component({
  selector: 'app-inactive-users',
  templateUrl: './inactive-users.component.html',
  styleUrls: ['./inactive-users.component.css']
})
export class InactiveUsersComponent implements OnInit {
  users: string[];

  constructor(public switchService: Switch) {

  }

  onSetToActive(i: number) {
    this.switchService.onSetToActive(i);
  }

  ngOnInit(): void {
    this.users = this.switchService.inactiveUsers
  }
}
