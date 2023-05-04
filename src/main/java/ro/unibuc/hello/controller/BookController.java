package ro.unibuc.hello.controller;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.unibuc.hello.dto.BookDTO;
import ro.unibuc.hello.service.BookService;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    MeterRegistry metricsRegistry;

    @PostMapping("/book/create")
    @ResponseBody
    public BookDTO createBook(@RequestParam(name="title") String title, @RequestParam(name="author") String author, @RequestParam(name="genre") String genre) {
        return bookService.createBook(title, author, genre);
    }
    @GetMapping("/book/getAll")
    @ResponseBody
    @Timed(value = "book.getAll.time", description = "Time taken to return all books")
    @Counted(value = "book.getAll.count", description = "Number of times all books were returned")
    public List<BookDTO> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/book/get")
    @ResponseBody
    public BookDTO getBook(@RequestParam(name="id") String id) {
        return bookService.getBook(id);
    }

    @DeleteMapping("/book/delete")
    @ResponseBody
    public String deleteBook(@RequestParam(name="id") String id) {
        return bookService.deleteBook(id);
    }

    @PutMapping("/book/edit")
    @ResponseBody
    @Timed(value = "book.edit.time", description = "Time taken to edit a book")
    @Counted(value = "book.edit.count", description = "Number of times books were edited")
    public BookDTO editBook(@RequestParam(name="id") String id, @RequestParam(name="title", required=false) String title, @RequestParam(name="author", required=false) String author, @RequestParam(name="genre", required=false) String genre) {
        return bookService.editBook(id, title, author, genre);
    }
}
