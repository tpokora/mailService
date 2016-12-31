import { MailserviceAngular2Page } from './app.po';

describe('mailservice-angular2 App', function() {
  let page: MailserviceAngular2Page;

  beforeEach(() => {
    page = new MailserviceAngular2Page();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
