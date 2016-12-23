import { Injectable } from 'angular2/core'
import { Http } from 'angular2/http'
import 'rxjs/add/operator/map'

@Injectable()
export class MailServiceHomeService {
    constructor(private _http: Http) { }

    getHome() {
        // returns "Observable"
        return this._http.get('http://localhost:8080/rest/home')
            .map(res => res.json());
    }
}