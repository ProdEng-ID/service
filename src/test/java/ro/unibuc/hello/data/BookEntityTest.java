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
    BookEntity myBook2;
   // String mybstr;
    @BeforeEach
    void setUp() {
        id = "1";
        title = "Title";
        author = "author";
        genre = "genre";
        myBook2 = new BookEntity();
        myBook2.setId(id);
        myBook2.setAuthor(author);
        myBook2.setGenre(genre);
        myBook2.setTitle(title);
      //mybstr = "Book[id='1', title='Title', author='author', genre='genre']";
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

   /* @Test
    void testToString() {
        Assertions.assertEquals(mybstr, myBook2.toString());
    } */

    BookEntity myBook = new BookEntity("Titlu", "autor","gen");

    @Test
    void test_title(){
        Assertions.assertSame("Titlu", myBook.getTitle());
    }

    @Test
    void test_author(){
        Assertions.assertSame("autor", myBook.getAuthor());
    }

    @Test
    void test_genre(){
        Assertions.assertSame("gen", myBook.getGenre());
    }



     /*@Test
    void test_string() { Assertions.assertSame( "Book[id='null', title='Titlu', author='autor', genre='gen']", myBook.toString());}*/



}
