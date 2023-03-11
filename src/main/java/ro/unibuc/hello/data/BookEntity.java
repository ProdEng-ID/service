package ro.unibuc.hello.data;

import org.springframework.data.annotation.Id;

public class BookEntity {
    @Id
    private String id;

    private String title;
    private String author;
    private String genre;

    public BookEntity() {}

    public BookEntity(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
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
        return String.format(
                "Book[title='%s', author='%s', genre='%s']",
                id, title, author, genre);
    }
}
