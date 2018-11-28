import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes, Router } from '@angular/router';
import { AppComponent } from '../app/app.component';
import { SeeallpostingsComponent as SeeAllPostings } from '../app/seeallpostings/seeallpostings.component'
import { CreatePostingComponent } from "../app/create-posting/create-posting.component"

const routes : Routes = [{path : 'all-postings', component : SeeAllPostings},
                          {path : 'create-posting', component : CreatePostingComponent},
                          { path: '', redirectTo: "/all-postings", pathMatch: 'full' }];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports:[
    RouterModule
  ]
})
export class AppRoutingModule { }
