package ro.unibuc.hello.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.unibuc.hello.data.BookEntity;
import ro.unibuc.hello.data.BookRepository;
import ro.unibuc.hello.dto.BookDTO;

import java.util.ArrayList;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public BookDTO createBook(String title, String author, String genre) {
        BookEntity book = new BookEntity(title, author, genre);
        return new BookDTO(bookRepository.save(book));
    }

    public ArrayList<BookDTO> getBooks() {
        ArrayList<BookDTO> bookDTOs = new ArrayList<>();
        bookRepository.findAll().forEach(bookEntity -> bookDTOs.add(new BookDTO(bookEntity)));
        return bookDTOs;
    }

    public BookDTO getBook(String id) {
        BookEntity bookEntity = bookRepository.findById(String.valueOf(new ObjectId(id))).orElse(null);
        if (bookEntity != null) {
            return new BookDTO(bookEntity);
        } else {
            return null;
        }
    }

    public String deleteBook(String id) {
        bookRepository.deleteById(String.valueOf(new ObjectId(id)));
        return "Book " + id + " has been successfully deleted.";
    }

    public BookDTO editBook(String id, String title, String author, String genre) {
        BookEntity book = bookRepository.findById(String.valueOf(new ObjectId(id))).orElse(null);
        if(book != null) {
            if(title != null)
                book.setTitle(title);
            if(author != null)
                book.setAuthor(author);
            if(genre != null)
                book.setGenre(genre);
            return new BookDTO(bookRepository.save(book));
        } else {
            return  null;
        }
    }

}
