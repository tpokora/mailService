import { Component } from 'angular2/core'
import { MailServiceHomeService } from './home.service'

@Component({
    selector: 'home',
    template: `
        <button (click)="getHome()">GET mail-service home content</button>
        <h2>{{ mailService.title }}</h2>
        <h3>{{ mailService.header }}</h3>
        `,
    providers: [MailServiceHomeService]
})
export class HomeComponent {
    mailService = {}

    constructor(private _httpService: MailServiceHomeService) { }

    getHome() {
        this._httpService.getHome()
            .subscribe(
            data => this.mailService = data,
            error => alert(error),
            () => console.log("Finished")
            );
    }
}