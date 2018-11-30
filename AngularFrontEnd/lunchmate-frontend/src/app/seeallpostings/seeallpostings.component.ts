import { Component, OnInit } from '@angular/core';
import { LoggedInUserService } from '../logged-in-user.service';
import { Observable } from 'rxjs';
import { Posting } from '../models/Posting';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-seeallpostings',
  templateUrl: './seeallpostings.component.html',
  styleUrls: ['./seeallpostings.component.css']
})
export class SeeallpostingsComponent implements OnInit {

  postingToMake : Posting;
  postingList : Posting[];

  constructor(private http : HttpClient, private login : LoggedInUserService) { }

  ngOnInit() {
    this.unpackAllPostings();
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
      var t = document.createElement("table");
      t.setAttribute("id", "postingTable");
      t.setAttribute("class", "table table-bordered table-hover table-striped");
      document.getElementById("mainBodyPostings").appendChild(t);
      
      var th = document.createElement("th");
      th.setAttribute("id", "th1-1");
      th.innerHTML = "Posting Name";
      document.getElementById("postingTable").appendChild(th);

      var th = document.createElement("th");
      th.setAttribute("id", "th1-2");
      th.innerHTML = "Description";
      document.getElementById("postingTable").appendChild(th);

      var th = document.createElement("th");
      th.setAttribute("id", "th1-3");
      th.innerHTML = "Contact Info";
      document.getElementById("postingTable").appendChild(th);

      for(var i = 0; i < this.postingList.length; i++)
      {
        console.log(this.postingList[i].name);
          var tr = document.createElement("tr");
          tr.setAttribute("id", "tr" + i);
          document.getElementById("postingTable").appendChild(tr);
          
          var th = document.createElement("th");
          th.setAttribute("id", "th1" + i);
          th.innerHTML = this.postingList[i].name.toString();
          document.getElementById("tr" + i).appendChild(th);

          var th = document.createElement("th");
          th.setAttribute("id", "th2" + i);
          th.innerHTML = this.postingList[i].description.toString();
          document.getElementById("tr" + i).appendChild(th);

          var th = document.createElement("th");
          th.setAttribute("id", "th3" + i);
          th.innerHTML = this.postingList[i].preferences.toString();
          document.getElementById("tr" + i).appendChild(th);
      }
    });
  }

}
