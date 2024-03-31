import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { Ex4Component } from './ex4/ex4.component';
import { GameControlComponent } from './ex4/game-control/game-control.component';
import { OddComponent } from "./ex4/odd/odd.component";
import { EvenComponent } from "./ex4/even/even.component";
import { Ex5Component } from './ex5/ex5.component';
import { ActiveUsersComponent } from './ex5/active-users/active-users.component';
import { InactiveUsersComponent } from './ex5/inactive-users/inactive-users.component';
import { Ex6Component } from './ex6/ex6.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { Ex7Component } from './ex7/ex7.component';


@NgModule({
  declarations: [
    AppComponent,
    Ex4Component,
    GameControlComponent,
    OddComponent,
    EvenComponent,
    Ex5Component,
    ActiveUsersComponent,
    InactiveUsersComponent,
    Ex6Component,
    Ex7Component
  ],
  imports: [
    BrowserModule,
    // FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
