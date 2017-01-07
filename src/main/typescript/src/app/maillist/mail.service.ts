import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import { Mail } from './mail.model';
import { environment } from '../../environments/environment'

@Injectable()
export class MailService {
    private emailsStatusListUrl = environment.API_URL + '/rest/emailstatus/list';

    constructor(private _http: Http) { }

    getMailStatusList(): Promise<Mail[]> {
        console.log('Getting mail list in service');
        return this._http.get(this.emailsStatusListUrl)
            .toPromise()
            .then(response => response.json() as Mail[])
            .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occured: ', error);
        return Promise.reject(error.message || error);
    }
}
