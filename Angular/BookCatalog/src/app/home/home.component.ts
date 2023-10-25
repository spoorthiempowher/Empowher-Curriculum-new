import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  searchInput: string = '';
  books: any[] = []; // Initialize with some sample data or fetch data from a service

  constructor(private bookService: BookService){
    this.bookService.getBooks().subscribe((res: any) => {
      this.books = res;
    });
  }

  ngOnInit(): void {
    
  }

  search() {
    // Add functionality for search
  }

  deleteBook(id: number){
    this.bookService.deleteBook(id).subscribe((res) => console.log(res));
  }
}
