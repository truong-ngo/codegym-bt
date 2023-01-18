import { Component } from "@angular/core";

@Component({
    selector: 'app-server',
    templateUrl: './server.component.html',
    styleUrls: ['./server.component.css'],
})
export class ServerComponent {
    serverId: number = 10;
    serverStatus: string = 'Offline';

    constructor() {
        this.serverStatus = Math.random() > 0.5 ? 'Online' : 'Offline';
    }

    getServerId() {
        return this.serverId;
    }

    getServerStatus() {
        return this.serverStatus;
    }

    getColor() {
        if (this.serverStatus === 'Online') return 'green';
        if (this.serverStatus === 'Offline') return 'red';
    }

    getClass() {
        if (this.serverStatus === 'Online') return 'online';
        if (this.serverStatus === 'Offline') return 'offline';
    }
}
