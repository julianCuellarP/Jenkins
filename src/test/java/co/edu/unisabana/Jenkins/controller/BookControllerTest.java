package co.edu.unisabana.Jenkins.controller;

import co.edu.unisabana.Jenkins.AbstractTest;
import co.edu.unisabana.Jenkins.dto.BookDto;
import co.edu.unisabana.Jenkins.dto.BookReponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

public class BookControllerTest extends AbstractTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private static final String PATH_REGISTER = "/book/register";

    private static final String Path_DATOS = "/book/search?q=";

    @Test
    public void Given_BasicTest_When_callData_Then_succesful() {
        BookDto dto = new BookDto("GOT", 1996, "George R.R", "Comercial", "suave");

        ResponseEntity<BookReponse> result = restTemplate.postForEntity(PATH_REGISTER, dto, BookReponse.class);
        assertEquals("Nuevo libro registrado", result.getBody().getData());
    }

    @Test
    public void Given_NewInformation_callData_Then_succcessful() {
        BookDto dto = new BookDto("GOT", 1996, "George R.R", "Comercial", "suave");
        restTemplate.postForEntity(PATH_REGISTER, dto, BookReponse.class);

        ResponseEntity<BookReponse> otroRegistro = restTemplate.postForEntity(PATH_REGISTER, dto, BookReponse.class);
        assertEquals("Actualizada cantidad", otroRegistro.getBody().getData());
    }

}
