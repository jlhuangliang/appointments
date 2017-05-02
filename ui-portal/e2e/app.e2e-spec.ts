import { UiPortalPage } from './app.po';

describe('ui-portal App', () => {
  let page: UiPortalPage;

  beforeEach(() => {
    page = new UiPortalPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
