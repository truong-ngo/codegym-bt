import {Directive, ElementRef, HostBinding, HostListener, Input, OnInit, Renderer2} from '@angular/core';

@Directive({
  selector: '[bHighlight]'
})
export class BHighlightDirective implements OnInit {
  @Input() defaultColor = 'transparent'
  @Input() highlightColor = 'lightgreen'
  @HostBinding('style.padding') padding: string = '20px'
  @HostBinding('style.backgroundColor') backgroundColor: string = this.defaultColor

  constructor(private element: ElementRef, private renderer: Renderer2) { }

  ngOnInit(): void {
    this.backgroundColor = this.defaultColor
    // this.renderer.setStyle(this.element.nativeElement, 'background-color', 'transparent')
    // this.renderer.setStyle(this.element.nativeElement, 'cursor', 'pointer')
  }

  @HostListener('mouseenter') mouseover(event: Event) {
    // this.renderer.setStyle(this.element.nativeElement, 'background-color', 'lightgreen')
    // this.renderer.setStyle(this.element.nativeElement, 'border', '1px solid green')
    this.padding = '10px'
    this.backgroundColor = this.highlightColor
  }

  @HostListener('mouseleave') mouseleave(event: Event) {
    // this.renderer.setStyle(this.element.nativeElement, 'background-color', 'transparent')
    // this.renderer.setStyle(this.element.nativeElement, 'border', 'none')
    this.padding = '0'
    this.backgroundColor = this.defaultColor
  }
}
