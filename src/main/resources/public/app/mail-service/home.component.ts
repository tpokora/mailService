import { Component } from 'angular2/core'
import { MailServiceHomeService } from './home.service'
import { HomeJSON } from './home.model'

@Component({
    selector: 'home',
    templateUrl: './app/mail-service/home.component.html',
    providers: [MailServiceHomeService, HomeJSON]
})
export class HomeComponent {

    constructor(private home: HomeJSON, private _httpService: MailServiceHomeService) {
    }

    getHome() {
        this._httpService.getHome()
            .subscribe(
            data => this.home = data,
            error => alert(error),
            () => console.log("Finished")
            );
    }

    clear() {
        this.home = new HomeJSON;
        console.log("Home element cleared");
    }
}