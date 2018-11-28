import { Component, OnInit } from '@angular/core';
import { ImplicitReceiver } from '@angular/compiler';

import { LoggedInUserService as LoginService } from '../app/logged-in-user.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'lunchmate-frontend';
  
  constructor(private login : LoginService){

  }

  ngOnInit(){

  }

  submitLogin()
  {
    this.login.isLoggedIn = true;
    console.log("" + this.login.loggedInuser.username + " is logged in now");
  }
}
