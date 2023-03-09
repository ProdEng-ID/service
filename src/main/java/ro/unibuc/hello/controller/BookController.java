package ro.unibuc.hello.controller;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.unibuc.hello.data.BookEntity;
import ro.unibuc.hello.data.BookRepository;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/book/create")
    @ResponseBody
    public BookEntity createBook(@RequestParam(name="title") String title, @RequestParam(name="author") String author, @RequestParam(name="genre") String genre) {
        return bookRepository.save(new BookEntity(title, author, genre));
    }
    @GetMapping("/book/getAll")
    @ResponseBody
    public List<BookEntity> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/book/get")
    @ResponseBody
    public BookEntity getBook(@RequestParam(name="id") String id) {
        return bookRepository.findById(String.valueOf(new ObjectId(id))).orElse(null);
    }
}
