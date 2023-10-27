import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import { Book } from '../model/book';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  searchInput: string = '';
  showSearch: boolean = true;
  books: Book[] = []; // Initialize with some sample data or fetch data from a service

  constructor(private bookService: BookService){
  }

  ngOnInit(): void {    
    //on page load
    this.getAllBooks();
  }

  getAllBooks(){
    this.bookService.getAllBooks().subscribe((res: any) => {
      this.books = res;
    });
  }

  search() {
    this.bookService.searchBookByName(this.searchInput).subscribe((res) => {
      this.books = res; 
      this.showSearch = false;
    });
  }

  reset(){
    this.searchInput = '';
    this.showSearch = true;
    this.getAllBooks();
  }

  deleteBook(id: number){
    this.bookService.deleteBook(id).subscribe((res) => this.getAllBooks());
  }
}
