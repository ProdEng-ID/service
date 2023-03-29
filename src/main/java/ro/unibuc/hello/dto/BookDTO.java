package ro.unibuc.hello.dto;

import org.springframework.data.annotation.Id;
import ro.unibuc.hello.data.BookEntity;

import java.util.Objects;

public class BookDTO {
    @Id
    private String id;
    private String title;
    private String author;
    private String genre;
    public BookDTO() {}

    public BookDTO(BookEntity book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.genre = book.getGenre();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDTO bookDTO = (BookDTO) o;
        return Objects.equals(id, bookDTO.id) && Objects.equals(title, bookDTO.title) && Objects.equals(author, bookDTO.author) && Objects.equals(genre, bookDTO.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, genre);
    }
}
