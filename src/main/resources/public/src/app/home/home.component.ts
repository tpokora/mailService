import { Component, OnInit } from '@angular/core';
import { HomeService } from './home.service';
import { HomeJSON } from './home.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [HomeService, HomeJSON]
})
export class HomeComponent implements OnInit {

  constructor(private _home: HomeJSON, private _homeService: HomeService) { }

  ngOnInit() {
  }

  getHome() {
    this._homeService.getHome()
      .subscribe(
      data => this._home = data,
      error => alert(error),
      () => console.log('Finished')
      );
  }

  clear() {
    this._home = new HomeJSON;
    console.log('Home element cleared');
  }

}
