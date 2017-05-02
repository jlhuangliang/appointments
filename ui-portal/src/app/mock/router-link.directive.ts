import { Directive, Input } from '@angular/core';

@Directive({
  selector: 'a[routerLink]',
})
export class MockRouterLinkDirective {

  @Input() routerLink;

  constructor() {
  }

}
