import { Component, OnInit, ViewChild } from '@angular/core';
//import { } from 'googlemaps';
import { HttpClient } from '@angular/common/http';
import { Posting } from '../models/Posting';
import { User } from '../models/user';
import { LoggedInUserService } from '../logged-in-user.service';
import { Observable } from 'rxjs';

declare const google:any;

@Component({
  selector: 'app-create-posting',
  templateUrl: './create-posting.component.html',
  styleUrls: ['./create-posting.component.css']
})
export class CreatePostingComponent implements OnInit {
 
  postingToMake : Posting;
  postingList;

  constructor(private http : HttpClient, private login : LoggedInUserService) { }

  ngOnInit() {
  }

  newPosting()
  {
    this.postingToMake = new Posting(1, "Lets Get Chicken", new Date("5/5/5"),"I like chicken, and am lonely", 25, "Nothing Vegan", [this.login.loggedInuser]);
    console.log(this.postingToMake.user);
    console.log(this.http.post<Posting>('http://ec2-54-89-36-209.compute-1.amazonaws.com:8091/LunchMate/postings', this.postingToMake));
  }

  getNullUser()
  {
    return this.http.get('http://ec2-54-89-36-209.compute-1.amazonaws.com:8091/LunchMate/users/22')
  }

  returnNullUser() : User
  {
    this.getNullUser().subscribe((data : User) => {
      return data;
    });

    return null;
  }

  getAllPostings(): Observable<Posting[]>
  {
     return this.http.get<Posting[]>('http://ec2-54-89-36-209.compute-1.amazonaws.com:8091/LunchMate/postings');
  }

  unpackAllPostings()
  {
    console.log("test");
    this.getAllPostings().subscribe((data : Posting[]) => {

      this.postingList = data;
    });
  }
}
