import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Book } from './model/book';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private baseUrl = 'http://localhost:8080';

  private booksUrl = this.baseUrl + '/books'; // Replace this URL with your backend API URL

  private authorsUrl = this.baseUrl + '/authors';

  private locationsUrl = this.baseUrl + '/locations';

  constructor(private http: HttpClient) { }

  getAllBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(this.booksUrl);
  }

  getBookById(id: number): Observable<Book> {
    return this.http.get<Book>(`${this.booksUrl}/${id}`);
  }

  searchBookByName(name: string){
    return this.http.get<Book[]>(`${this.booksUrl}/search?name=${name}`);
  }

  createBook(book: Book): Observable<Book> {
    return this.http.post<Book>(this.booksUrl, book);
  }

  updateBook(book: Book): Observable<Book> {
    return this.http.put<Book>(`${this.booksUrl}/${book.id}`, book);
  }

  deleteBook(id: number): Observable<any> {
    return this.http.delete(`${this.booksUrl}/${id}`);
  }

  getAuthors(): Observable<any>{
    return this.http.get(`${this.authorsUrl}`);
  }

  getLocations(): Observable<any>{
    return this.http.get(`${this.locationsUrl}`);
  }
}
