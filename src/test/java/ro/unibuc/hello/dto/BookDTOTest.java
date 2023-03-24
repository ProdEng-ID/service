package ro.unibuc.hello.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookDTOTest {
    String id;
    String title;
    String author;
    String genre;
    BookDTO bookDTO;
    String bookDTOString;
    @BeforeEach
    void setUp() {
        id = "61ab35dacf174baf213";
        title = "Book";
        author = "John Doe";
        genre = "Fantasy";
        bookDTO = new BookDTO();
        bookDTO.setId(id);
        bookDTO.setTitle(title);
        bookDTO.setAuthor(author);
        bookDTO.setGenre(genre);
        bookDTOString = "BookDTO{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    @Test
    void getId() {
        Assertions.assertEquals(id, bookDTO.getId());
    }

    @Test
    void getTitle() {
        Assertions.assertEquals(title, bookDTO.getTitle());
    }

    @Test
    void getAuthor() {
        Assertions.assertEquals(author, bookDTO.getAuthor());
    }

    @Test
    void getGenre() {
        Assertions.assertEquals(genre, bookDTO.getGenre());
    }

    @Test
    void testToString() {
        Assertions.assertEquals(bookDTOString, bookDTO.toString());
    }
}