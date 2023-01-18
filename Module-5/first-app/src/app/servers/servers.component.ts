import { Component } from '@angular/core';

@Component({
  selector: 'app-servers',
  templateUrl: './servers.component.html',
  styleUrls: ['./servers.component.css']
})
export class ServersComponent {
    isDisable = false;
    isClickAble = false;
    serverCreationStatus = 'No server created';
    serverName = 'Truong';
    isCreated = false;
    servers = ['Test server', 'Test server 2']
    constructor() {
        setTimeout(() => {
            this.isDisable = true;
            this.isClickAble = true;
        }, 2000)
    }

    onCreationServer() {
        this.servers.push(this.serverName)
        this.isCreated = true;
        this.serverCreationStatus = 'Server was created, name is: ' + this.serverName;
    }

    onUpdateServerName(event: Event) {
        this.serverName = (<HTMLInputElement>event.target).value;
    }
}
