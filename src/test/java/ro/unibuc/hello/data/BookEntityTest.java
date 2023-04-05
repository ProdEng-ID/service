package ro.unibuc.hello.data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BookEntityTest {

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

   /* @Test
    void test_string() { Assertions.assertSame( "Book[title='Titlu', author='autor', genre='gen']", myBook.toString());}*/



}