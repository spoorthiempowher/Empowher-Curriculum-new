import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { BookService } from '../book.service';

@Component({
  selector: 'app-bookdetail',
  templateUrl: './bookdetail.component.html',
  styleUrls: ['./bookdetail.component.css']
})
export class BookdetailComponent implements OnInit {

  id: any;
  newBook: any = { id: '', title: '', author: '' };
  status;

  constructor(private route: ActivatedRoute, private bookService: BookService) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.id = +params.get('bookId');      
      this.bookService.getBook(this.id).subscribe((res) => {
        this.newBook = {...res};
      });
    })
  }

  addBook() {
    this.bookService.addBook({ title: this.newBook.title, author: this.newBook.author }).subscribe((res) => this.status=200, (err) => this.status=500);
    this.newBook = { title: '', author: '' }; // Clear the form after adding a book
  }

}
