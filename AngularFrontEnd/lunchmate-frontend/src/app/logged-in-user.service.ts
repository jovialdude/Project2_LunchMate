import { Injectable } from '@angular/core';
import { User } from '../app/models/user'

@Injectable({
  providedIn: 'root'
})
export class LoggedInUserService {

  isLoggedIn : boolean = false;
  loggedInuser : User = new User(-1, "First", "Username", "Password", "123-456-7890", "dummy@email.scam");

  constructor() { }
}
