import {Directive, ElementRef, HostBinding, HostListener} from '@angular/core';

@Directive({
  selector: '[dropdown]'
})
export class DropdownDirective {

  @HostBinding('class.open') isOpen:boolean = false;

  constructor(private element: ElementRef) { }

  @HostListener('click') click(event: Event) {
    this.isOpen = !this.isOpen;
  }

  // @HostListener('document:click', ['$event']) toggleOpen(event: Event) {
  //   this.isOpen = this.element.nativeElement.contains(event.target) ? !this.isOpen : false;
  // }
}
