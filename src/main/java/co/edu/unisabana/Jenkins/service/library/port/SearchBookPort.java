package co.edu.unisabana.Jenkins.service.library.port;

import co.edu.unisabana.Jenkins.repository.dao.entity.BookEntity;

import java.util.List;

public interface SearchBookPort {

    boolean validateExistsBook(String nameBook);
    List<BookEntity> searchBook (String autor);
}
