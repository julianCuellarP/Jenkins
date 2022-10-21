package co.edu.unisabana.Jenkins.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import co.edu.unisabana.Jenkins.service.library.model.Book;
import co.edu.unisabana.Jenkins.service.library.model.CategoryBook;
@Data
@AllArgsConstructor
public class BookDto {

    private String name;
    private int year;
    private String author;
    private String rated;
    private String category;


    public Book toModel() {
        boolean rRated = rated.equals("Adult");
        return new Book(this.name, this.year, this.author, rRated, CategoryBook.fromString(category));
    }
}
