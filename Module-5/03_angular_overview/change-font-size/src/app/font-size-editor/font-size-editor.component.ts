import { Component } from '@angular/core';

@Component({
    selector: 'app-font-size-editor',
    templateUrl: './font-size-editor.component.html',
    styleUrls: ['./font-size-editor.component.css']
})
export class FontSizeEditorComponent {
    fontSize = '14';

    changeFontSizeValue(event: Event) {
        this.fontSize = (<HTMLInputElement>event.target).value;
    }
}
