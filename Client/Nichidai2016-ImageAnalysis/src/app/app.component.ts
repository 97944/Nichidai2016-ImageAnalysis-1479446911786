import { Component } from '@angular/core';
var watson = require('watson-developer-cloud');

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = '日大特別講義2016 画像解析アプリ';
  private alc: any;
  
  private parameters = {
    url: 'http://www.charliechaplin.com/en/synopsis/articles/29-The-Great-Dictator-s-Speech'
  };
  
  private watson(): void{
    this.alc = watson.alchemy_language({
        api_key: '25d7ba025058cc03b15c7ceaaec6015fb5ff5322'
      });
    this.alc.emotion(this.parameters, function (err, response) {
      if (err) console.log('error:', err);
      else console.log(JSON.stringify(response, null, 2));
    }
    );
  }
  
}
