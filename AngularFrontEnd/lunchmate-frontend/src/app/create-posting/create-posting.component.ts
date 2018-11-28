import { Component, OnInit, ViewChild } from '@angular/core';
//import { } from 'googlemaps';
import { HttpClient } from '@angular/common/http';

declare const google:any;

@Component({
  selector: 'app-create-posting',
  templateUrl: './create-posting.component.html',
  styleUrls: ['./create-posting.component.css']
})
export class CreatePostingComponent implements OnInit {

  @ViewChild('gmap') gmapElement: any;
  map: google.maps.Map;
  infoWindow : google.maps.InfoWindow;
  service : google.maps.places.PlacesService;

  constructor(private http:HttpClient) { }

  ngOnInit() {
    var mapProp = {
      center: new google.maps.LatLng(18.5793, 73.8143),
      zoom: 15,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    this.map = new google.maps.Map(this.gmapElement.nativeElement, mapProp);

    this.infoWindow = new google.maps.InfoWindow;

    var request = {query : 'Museum of Contemporary Art Australia', fields: ['photos','formatted_address','name','rating','opening_hours','geometry'],};

    this.service = new google.maps.places.PlacesService(this.map);
    console.log(this.service);
    this.service.findPlaceFromQuery(request, this.RequestFunction);
    this.GeolocationFunction(this.infoWindow, this.map);
  }

  RequestFunction(results, status)
  {
    if (status == google.maps.places.PlacesServiceStatus.OK) {
      for (var i = 0; i < results.length; i++) {
        var place = results[i];
        console.log(place.formatted_address);
      } 
  }
}

  GeolocationFunction(infoW : google.maps.InfoWindow, m : google.maps.Map)
  {
     // Try HTML5 geolocation.
     if (navigator.geolocation) 
     {
       navigator.geolocation.getCurrentPosition(function(position) {
         var pos = {
           lat: position.coords.latitude,
           lng: position.coords.longitude
         };
 
         console.log(infoW);
         console.log(m);   

         infoW.setPosition(pos);
         infoW.setContent('Location found.');
         infoW.open(m);
         console.log("Map Found");
         m.setCenter(pos);
       }, function() {
        infoW.setPosition(m.getCenter());
        infoW.setContent(true ?
                               'Error: The Geolocation service failed.' :
                               'Error: Your browser doesn\'t support geolocation.');
                               infoW.open(m);
       });
     } 
     else 
     {
       // Browser doesn't support Geolocation
       infoW.setPosition(m.getCenter());
       infoW.setContent(false ?
                               'Error: The Geolocation service failed.' :
                               'Error: Your browser doesn\'t support geolocation.');
                               infoW.open(m);
     }
  }
}
