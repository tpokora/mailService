import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class HomeService {
    constructor(private _http: Http) { }

    getHome() {
        // returns Objectable
        return this._http.get('http://localhost:8080/rest/home')
            .map(res => res.json());
    }
}
