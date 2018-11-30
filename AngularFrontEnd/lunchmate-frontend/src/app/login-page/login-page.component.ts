import { Component, OnInit } from '@angular/core';

import { LoggedInUserService as LoginService } from '../../app/logged-in-user.service'

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {
  
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
