import { Component, OnInit } from '@angular/core';

import { LoggedInUserService as LoginService } from '../../app/logged-in-user.service'
import { User } from '../models/user';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {
  
  attemptedUser$ : User;

  emailField : string = "";
  passwordField : string = ""

  constructor(private loginC : LoginService, private http : HttpClient){

  }

  ngOnInit(){

  }

  submitLogin()
  {
    //console.log(this.login.loggedInuser);
    this.attemptedUser$ = new User(-1, "First", "Last", this.emailField, this.passwordField, 1234567890);
    console.log("" + this.loginC.isLoggedIn + this.emailField);

    this.openAllUsers();
  }

  getLoginStatus()
  {
    return this.loginC.isLoggedIn;
  }

  getLogin()
  {
    return this.http.post<User>('http://ec2-54-89-36-209.compute-1.amazonaws.com:8091/LunchMate/login', this.attemptedUser$)
  }

  openAllUsers()
  {
    this.getLogin().subscribe((data : User) => {

      if(data.id > -1)
      {
        console.log(this.loginC.isLoggedIn);
        this.attemptedUser$ = data;
        this.loginC.isLoggedIn = true;
        console.log(this.loginC.isLoggedIn);
      }
      else
      {
          document.getElementById("loginStatus").innerHTML = "Please Enter A Valid Login";
          this.emailField = "";
          this.passwordField = "";
      }
    });
  }
}
