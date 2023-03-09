package ro.unibuc.hello.data;

import org.springframework.data.annotation.Id;

public class BookEntity {
    @Id
    public String id;

    public String title;
    public String author;
    public String genre;

    public BookEntity() {}

    public BookEntity(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format(
                "Book[title='%s', author='%s', genre='%s']",
                id, title, author, genre);
    }
}
