package co.edu.unisabana.Jenkins.logic;

import co.edu.unisabana.Jenkins.logica.LibroServicio;
import co.edu.unisabana.Jenkins.service.library.model.Book;
import co.edu.unisabana.Jenkins.service.library.model.CategoryBook;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibroServicioTest {


   private LibroServicio servicio = new LibroServicio();
    private Book book1 = new Book("El señor de los anillos", 1954,"J.R. Tolkien", false, CategoryBook.SOFT_COVER);
    private Book book2 = new Book("El señor de los anillos 2", 1963,"J.R. Tolkien", false, CategoryBook.HARD_COVER);
    private Book book3 = new Book("El señor de los anillos 3", 1973,"J.R. Tolkien", false, CategoryBook.HARD_COVER);


    @Test
    public void Given_books_ok_When_getBooks_Then_return_list(){
        List<Book> listado = new ArrayList();
        listado.add(book1);
        listado.add(book2);
        assertFalse(listado.isEmpty());
    }

    @Test
    public void Given_no_books_ok_When_getBooks_Then_return_empty(){
        List<Book> listado = new ArrayList();
        assertTrue(listado.isEmpty());
    }

    @Test
    public void Given_Book_name_ok_When_getBook_then_return_book(){
        List<Book> resultados = new ArrayList<>();
        resultados.add(servicio.getBook("El señor de los anillos"));
        assertEquals(1,resultados.size());
    }
    @Test
    public void Given_Book_name_wrong_When_getBook_then_return_empty(){
        assertEquals(null,servicio.getBook("maze runner"));
    }
    @Test
    public void Given_book_ok_When_addBook_Then_succes(){
        List<Book> listado = new ArrayList();
        listado.add(servicio.addBook(book1));
        assertFalse(listado.isEmpty());
    }
    @Test
    public void Given_list_not_empty_When_getMaximo_Then_return_size(){
        List<Book> listado = new ArrayList();
        listado.add(book1);
        listado.add(book2);
        listado.add(book3);
        assertEquals(3,servicio.getMaximo(listado));
    }
 @Test
    public void  Given_list_empty_When_getMaximo_Then_return_size(){
     List<Book> listado = new ArrayList();
     assertEquals(0,servicio.getMaximo(listado));
 }
}
