import { Nichidai2016ImageAnalysisPage } from './app.po';

describe('nichidai2016-image-analysis App', function() {
  let page: Nichidai2016ImageAnalysisPage;

  beforeEach(() => {
    page = new Nichidai2016ImageAnalysisPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
