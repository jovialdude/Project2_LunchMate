import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-google-maps-features',
  templateUrl: './google-maps-features.component.html',
  styleUrls: ['./google-maps-features.component.css']
})
export class GoogleMapsFeaturesComponent  implements OnInit {

  @ViewChild('gmap') gmapElement: any;
  map: google.maps.Map;
  infoWindow : google.maps.InfoWindow;
  service : google.maps.places.PlacesService;
  circleArea : google.maps.Circle;

  constructor(private http:HttpClient) { }

  ngOnInit() {
    var mapProp = {
      center: new google.maps.LatLng(18.5793, 73.8143),
      zoom: 15,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    this.map = new google.maps.Map(this.gmapElement.nativeElement, mapProp);

    this.infoWindow = new google.maps.InfoWindow;
    


    this.service = new google.maps.places.PlacesService(this.map);
    this.GeolocationFunction(this.infoWindow, this.map, this.circleArea, this.service);
  }

  GeolocationFunction(infoW : google.maps.InfoWindow, m : google.maps.Map, c : google.maps.Circle, s : google.maps.places.PlacesService)
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

         c = new google.maps.Circle;
         c.setCenter(infoW.getPosition());
         c.setMap(m);
         c.setRadius(2000);
         console.log(c.getCenter());
     
         var request = {location: infoW.getPosition(), radius : 2000, type: 'restaurant'};
     
         s.nearbySearch(request, (results, status) => {
          if (status == google.maps.places.PlacesServiceStatus.OK) {
            for (var i = 0; i < results.length; i++) {
              var place = results[i];
              console.log(place.name);
            } 
        }});

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