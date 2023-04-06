package ro.unibuc.hello.data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookEntityTest {

    String id;
    String title;
    String author;
    String genre;
    BookEntity myBook;
    BookEntity myBook2;
    String myBook2String;
    @BeforeEach
    void setUp() {
        id = "1";
        title = "Title";
        author = "author";
        genre = "genre";
        myBook = new BookEntity("Titlu", "autor","gen");
        myBook2 = new BookEntity();
        myBook2.setId(id);
        myBook2.setAuthor(author);
        myBook2.setGenre(genre);
        myBook2.setTitle(title);
        myBook2String = "Book[id='1', title='Title', author='author', genre='genre']";
    }

    @Test
    void getId() {
        Assertions.assertEquals(id, myBook2.getId());
    }

    @Test
    void getTitle() {
        Assertions.assertEquals(title, myBook2.getTitle());
    }

    @Test
    void getAuthor() {
        Assertions.assertEquals(author, myBook2.getAuthor());
    }

    @Test
    void getGenre() {
        Assertions.assertEquals(genre, myBook2.getGenre());
    }

   @Test
    void testToString() {
        Assertions.assertEquals(myBook2String, myBook2.toString());
    }



}
