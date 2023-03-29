package ro.unibuc.hello.service;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ro.unibuc.hello.data.BookEntity;
import ro.unibuc.hello.data.BookRepository;
import ro.unibuc.hello.dto.BookDTO;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookServiceTest {
    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookService bookService;

    BookEntity bookEntity;
    BookEntity bookEntityWithId;
    BookEntity updatedBookEntity;
    ArrayList<BookEntity> bookEntities;
    BookDTO bookDTO;
    BookDTO updatedBookDTO;
    ArrayList<BookDTO> bookDTOs;
    String deleteString;

    @BeforeEach
    void setUp() {
        bookEntity = new BookEntity("Book", "John Doe", "Fantasy");
        bookEntityWithId = new BookEntity("Book", "John Doe", "Fantasy");
        bookEntityWithId.setId("6413456b37d7e23385bfe7f1");
        updatedBookEntity = new BookEntity("Book 2", "Jane Doe", "Horror");
        updatedBookEntity.setId(bookEntityWithId.getId());
        bookEntities = new ArrayList<>();
        bookEntities.add(bookEntityWithId);
        bookDTO = new BookDTO(bookEntityWithId);
        updatedBookDTO = new BookDTO(updatedBookEntity);
        bookDTOs = new ArrayList<>();
        bookDTOs.add(bookDTO);
        deleteString = "Book " + bookEntityWithId.getId() + " has been successfully deleted.";
    }

    @Test
    void createBook() {
        when(bookRepository.save(bookEntity)).thenReturn(bookEntityWithId);
        BookDTO result = bookService.createBook(bookEntityWithId.getTitle(), bookEntityWithId.getAuthor(), bookEntityWithId.getGenre());
        Assertions.assertEquals(result, bookDTO);
    }

    @Test
    void getBooks() {
        doReturn(bookEntities).when(bookRepository).findAll();
        ArrayList<BookDTO> result = bookService.getBooks();
        Assertions.assertEquals(result, bookDTOs);
    }

    @Test
    void getBook() {
        when(bookRepository.findById(String.valueOf(new ObjectId(bookEntityWithId.getId())))).thenReturn(Optional.ofNullable(bookEntityWithId));
        BookDTO result = bookService.getBook(bookEntityWithId.getId());
        Assertions.assertEquals(result, bookDTO);
    }

    @Test
    void deleteBook() {
        String result = bookService.deleteBook(bookEntityWithId.getId());
        Assertions.assertEquals(result, deleteString);
    }

    @Test
    void editBook() {
        when(bookRepository.findById(String.valueOf(new ObjectId(bookEntityWithId.getId())))).thenReturn(Optional.ofNullable(bookEntityWithId));
        when(bookRepository.save(updatedBookEntity)).thenReturn(updatedBookEntity);
        BookDTO result = bookService.editBook(bookEntityWithId.getId(), "Book 2", "Jane Doe", "Horror");
        Assertions.assertEquals(result, updatedBookDTO);
    }

}