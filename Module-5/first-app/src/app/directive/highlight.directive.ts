import {Directive, ElementRef, OnInit} from "@angular/core";

@Directive({
  selector: '[highlight]'
})
export class HighlightDirective implements OnInit {
  constructor(private element: ElementRef) {
  }

  ngOnInit(): void {
    this.element.nativeElement.style.backgroundColor = 'lightgreen'
  }

}
