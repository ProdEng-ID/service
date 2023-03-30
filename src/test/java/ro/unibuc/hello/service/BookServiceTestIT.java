package ro.unibuc.hello.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ro.unibuc.hello.data.BookRepository;
import ro.unibuc.hello.dto.BookDTO;

@SpringBootTest
@Tag("IT")
public class BookServiceTestIT {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    @Test
    void getBook() {
        BookDTO book = bookService.getBook("6413456b37d7e23385bfe7f2");
        Assertions.assertEquals(book.getId(), "6413456b37d7e23385bfe7f2");
        Assertions.assertEquals(book.getTitle(), "Book");
        Assertions.assertEquals(book.getAuthor(), "John Doe");
        Assertions.assertEquals(book.getGenre(), "Fantasy");
    }
}
