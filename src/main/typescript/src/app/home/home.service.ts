import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import { environment } from '../../environments/environment'

@Injectable()
export class HomeService {
    constructor(private _http: Http) { }

    getHome() {
        // returns Objectable
        return this._http.get(environment.API_URL + 'rest/home')
            .map(res => res.json());
    }
}
