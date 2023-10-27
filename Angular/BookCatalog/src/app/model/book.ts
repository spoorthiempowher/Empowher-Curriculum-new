import { Author } from "./author";
import { Location } from "./location";

export interface Book {
    id: number;
	name: string;
	price: number;
    publisher: string;
    isbn: number;
    quantity: number;
    author: Author;
    location?: Location;
}