import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { BookService } from '../book.service';
import { Book } from '../model/book';

@Component({
  selector: 'app-bookdetail',
  templateUrl: './bookdetail.component.html',
  styleUrls: ['./bookdetail.component.css']
})
export class BookdetailComponent implements OnInit {

  id: any;
  newBook: Book = {...this.getNewBook()};
  status;
  authors = [];
  locations = [];

  constructor(private route: ActivatedRoute, private bookService: BookService) {     
  }

  ngOnInit(): void {    
    this.bookService.getAuthors().subscribe((res)=>this.authors=[...res]);
    this.bookService.getLocations().subscribe((res)=>this.locations=[...res]);
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.id = +params.get('bookId'); 
      if(this.id){     
        this.bookService.getBookById(this.id).subscribe((res) => {
          this.newBook = {...res};
          this.newBook.author = this.authors.filter(a => a.id === this.newBook.author.id)[0];
          this.newBook.location = this.locations.filter(l => l.id === this.newBook.location.id)[0];
        });
      }
    });
  }

  addOrUpdateBook() {
    this.status = null;
    if(this.newBook.id != null){
      this.bookService.updateBook(this.newBook).subscribe(
        (res) => this.status=200, (err) => this.status=500
      );
    }else{
      this.bookService.createBook(this.newBook).subscribe(
        (res) => this.status=200, (err) => this.status=500
      );     
      if(this.status == 200){
        this.newBook = {...this.getNewBook()}; // Clear the form after adding a book
      } 
    }
  }

  getNewBook(){
    return { 
      id: null,
      name: '',
      price: 0,
      publisher: '',
      isbn: 0,
      quantity: 0,
      author: null,
      location: null
    };
  }
}
