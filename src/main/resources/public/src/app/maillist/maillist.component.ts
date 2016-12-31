import { Component, OnInit } from '@angular/core';
import { MailService } from './mail.service';
import { Mail } from './mail.model';

@Component({
  selector: 'app-maillist',
  templateUrl: './maillist.component.html',
  styleUrls: ['./maillist.component.css'],
  providers: [MailService, Mail]
})
export class MaillistComponent implements OnInit {
  _maillist: Mail[] = [];
  newMail: Mail;

  constructor(private _mailservice: MailService) { }

  ngOnInit() {
    this.getMailStatusList();
  }

  // add(email: string): void {
  //   email = email.trim();
  //   if (!email) {
  //     return;
  //   }
  //   this.newMail = new Mail();
  //   this.newMail.email = email;
  //   this._maillist.push(this.newMail);
  // }

  getMailStatusList(): void {
    console.log('Getting mail list');
    this._mailservice
      .getMailStatusList()
      .then(maillist => this._maillist = maillist);
  }

}
