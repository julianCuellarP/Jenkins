package co.edu.unisabana.Jenkins.service.library.port;

import co.edu.unisabana.Jenkins.service.library.model.Book;

import java.util.List;

public interface RegisterBookPort {

    List registerBook(Book newBook);
}

