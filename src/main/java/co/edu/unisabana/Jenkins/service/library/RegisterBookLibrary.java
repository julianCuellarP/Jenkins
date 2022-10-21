package co.edu.unisabana.Jenkins.service.library;

import co.edu.unisabana.Jenkins.service.library.model.Book;
import co.edu.unisabana.Jenkins.service.library.port.AddBookPort;
import co.edu.unisabana.Jenkins.service.library.port.RegisterBookPort;
import co.edu.unisabana.Jenkins.service.library.port.SearchBookPort;
import org.springframework.stereotype.Service;

@Service
public class RegisterBookLibrary {

    private final SearchBookPort searchBookPort;
    private final AddBookPort addBookPort;
    private final RegisterBookPort registerBookPort;

    public RegisterBookLibrary(SearchBookPort searchBookPort, AddBookPort addBookPort, RegisterBookPort registerBookPort) {
        this.searchBookPort = searchBookPort;
        this.addBookPort = addBookPort;
        this.registerBookPort = registerBookPort;
    }


    public int registerBook(Book book) {
        boolean exists = searchBookPort.validateExistsBook(book.getName());
        if (exists) {
            addBookPort.addBook(book.getName());
            return 1;
        } else {
            registerBookPort.registerBook(book);
            return 2;
        }
    }


}
