package ro.unibuc.hello.service;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ro.unibuc.hello.data.BookEntity;
import ro.unibuc.hello.data.BookRepository;
import ro.unibuc.hello.dto.BookDTO;
import org.junit.jupiter.api.BeforeEach;
import org.bson.types.ObjectId;
@SpringBootTest
@Tag("IT")
public class BookServiceTestIT {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    BookEntity mybook;
    String deleteresp;
    String id;

    String str;

    @BeforeEach
    void setUp() {
        id = "6413456b37d7e23385bfe7f2";
        mybook = new BookEntity("Title2", "Author2","genre2");
        mybook.setId(id);
        deleteresp = "Book " + id + " has been successfully deleted.";
    }

    @Test
    void insertUser() {
        BookDTO result = bookService.createBook(mybook.getTitle(), mybook.getAuthor(), mybook.getGenre());

        Assertions.assertEquals(result.getTitle(), "Title2");
        Assertions.assertEquals(result.getAuthor(), "Author2");
        Assertions.assertEquals(result.getGenre(), "genre2");
    }

    @Test
    void deleteBook() {
        bookRepository.save(mybook);
        String result = bookService.deleteBook(id);
        Assertions.assertEquals(result, deleteresp);
    }


    @Test
    void getBook() {
        BookDTO book = bookService.getBook("6413456b37d7e23385bfe7f2");
        Assertions.assertEquals(book.getId(), "6413456b37d7e23385bfe7f2");
        Assertions.assertEquals(book.getTitle(), "Book");
        Assertions.assertEquals(book.getAuthor(), "John Doe");
        Assertions.assertEquals(book.getGenre(), "Fantasy");
    }
    
}
