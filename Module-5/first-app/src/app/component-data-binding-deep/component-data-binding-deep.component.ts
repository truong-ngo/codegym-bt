import { Component } from '@angular/core';

@Component({
  selector: 'app-component-data-binding-deep',
  templateUrl: './component-data-binding-deep.component.html',
  styleUrls: ['./component-data-binding-deep.component.css']
})
export class ComponentDataBindingDeepComponent {
  serverElements = [{type: 'server', name: 'Test server', content: 'server content'}, {type: 'blueprint', name: 'Test server', content: 'server content'}];

  onServerAdded(data: {serverName: string, serverContent: string}) {
    this.serverElements.push({
      type: 'server',
      name: data.serverName,
      content: data.serverContent
    });
  }

  onBlueprintAdded(data: {serverName: string, serverContent: string}) {
    this.serverElements.push({
      type: 'blueprint',
      name: data.serverName,
      content: data.serverContent
    });
  }
}
