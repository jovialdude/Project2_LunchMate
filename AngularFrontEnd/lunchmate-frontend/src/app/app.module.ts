import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { SeeallpostingsComponent } from './seeallpostings/seeallpostings.component';
import { PostingsComponent } from './postings/postings.component';
import { AppRoutingModule } from './app-routing.module';
import { CreatePostingComponent } from './create-posting/create-posting.component';

import { HttpClientModule } from '@angular/common/http';
import { GoogleMapsFeaturesComponent } from './google-maps-features/google-maps-features.component';

@NgModule({
  declarations: [
    AppComponent,
    SeeallpostingsComponent,
    PostingsComponent,
    CreatePostingComponent,
    GoogleMapsFeaturesComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
