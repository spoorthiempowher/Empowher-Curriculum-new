import { Injectable } from '@angular/core';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  books: any[] = [
    {id: 1, title: 'One', author: 'Author 1'},
    {id: 2, title: 'Two', author: 'Author 2'}
  ];

  constructor() { }

  getBooks(){
    return of(this.books);
  }

  getBook(id: number){
    return of(this.books.filter(book => book.id == id)[0]);
  }

  addBook(book: any){
    return of(this.books.push(book));
  }

  updateBook(book: any, id: number){
    let b = this.getBook(id);

  }

  deleteBook(id: number){
    return of();
  }
}
