import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { ServerComponent } from "./server/server.component";
import { ServersComponent } from './servers/servers.component';
import { FormsModule } from "@angular/forms";
import { ComponentDataBindingDeepComponent } from './component-data-binding-deep/component-data-binding-deep.component';
import { CockpitComponent } from './component-data-binding-deep/cockpit/cockpit.component';
import { ServerElementComponent } from './component-data-binding-deep/server-element/server-element.component';

@NgModule({
  declarations: [
    AppComponent,
    ServerComponent,
    ServersComponent,
    ComponentDataBindingDeepComponent,
    CockpitComponent,
    ServerElementComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
