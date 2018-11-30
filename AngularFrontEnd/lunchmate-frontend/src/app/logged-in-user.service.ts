import { Injectable } from '@angular/core';
import { User } from '../app/models/user'

@Injectable({
  providedIn: 'root'
})
export class LoggedInUserService {

  isLoggedIn : boolean = false;
  loggedInuser : User = new User(22, null, null, "null@Nnull.null", "nullpass", null);

  constructor() { }
}
