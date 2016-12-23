import { Component } from 'angular2/core';
import { HomeComponent } from './mail-service/home.component'

@Component({
    selector: 'my-app',
    template: '<home></home>',
    directives: [HomeComponent]
})
export class AppComponent { }