package co.edu.unisabana.Jenkins.logica;
import java.util.ArrayList;
import java.util.List;

import co.edu.unisabana.Jenkins.service.library.model.Book;


public class LibroServicio {

    private List<Book> listado = LogicaNegocio.getInstance().getListado();

    public List<Book> getBooks(){
        return listado;
    }

    public Book getBook(String name ){
        for (Book book : listado){
            if (book.getName()==name){
                return book;

            }
        }
        return null;
    }

    public Book addBook(Book book){
        book.setName();
        listado.add(book);
        return book;
    }

    public int getMaximo(List<Book> listado){
        int size = listado.size();
        if (size > 0){
            return size;

        }
        return 0;
    }
}
