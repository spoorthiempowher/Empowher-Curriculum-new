import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { BookdetailComponent } from './bookdetail/bookdetail.component';

const routes: Routes = [ 
  { path: 'home', component: HomeComponent },
  {path: 'book', redirectTo: 'book/', pathMatch: 'full'},
  {path: 'book/:bookId', component: BookdetailComponent},
  { path: '',   redirectTo: '/home', pathMatch: 'full' },
  { path: '**', redirectTo: '/home' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
