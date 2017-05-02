import { Directive, Input } from '@angular/core';

// tslint:disable:directive-selector
@Directive({
  selector: 'a[routerLink]',
})
export class MockRouterLinkDirective {

  @Input() routerLink;

  constructor() {
  }

}
