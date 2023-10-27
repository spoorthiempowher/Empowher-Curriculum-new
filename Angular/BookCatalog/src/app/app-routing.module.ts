import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { BookdetailComponent } from './bookdetail/bookdetail.component';

const routes: Routes = [ 
  { path: 'home', component: HomeComponent },
  {path: 'books', redirectTo: 'books/', pathMatch: 'full'},
  {path: 'books/:bookId', component: BookdetailComponent},
  { path: '',   redirectTo: '/home', pathMatch: 'full' }, //default / landing page
  { path: '**', redirectTo: '/home' } //any unknown path
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
