package co.edu.unisabana.Jenkins.controller;


import co.edu.unisabana.Jenkins.dto.BookDto;
import co.edu.unisabana.Jenkins.dto.BookReponse;
import co.edu.unisabana.Jenkins.repository.dao.BookDao;
import co.edu.unisabana.Jenkins.repository.dao.entity.BookEntity;
import co.edu.unisabana.Jenkins.service.library.RegisterBookLibrary;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {

    private final RegisterBookLibrary registerBookLibrary;


    public BookController(RegisterBookLibrary registerBookLibrary) {
        this.registerBookLibrary = registerBookLibrary;
    }

    // Pendiente validar uso de exception handler
    // explicar camel case
    @PostMapping("/register")
    @ResponseBody
    public BookReponse registerBook(@RequestBody BookDto bookDto) {
        int result = registerBookLibrary.registerBook(bookDto.toModel());
        if (result == 1) {
            return new BookReponse("Actualizada cantidad");
        }
        return new BookReponse("Nuevo libro registrado");


    }

    @GetMapping("/search")
    public List<BookEntity> searchBook(@RequestParam String q) {
        BookDao bookDao = new BookDao();
        List<BookEntity> results = bookDao.searchBook(q);
        return results;
    }
}