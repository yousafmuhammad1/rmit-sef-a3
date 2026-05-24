import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookIntegrationTest {

    @Test
    void shouldStoreValidBook() {

        BookRepository repository =
                new BookRepository();

        BookService service =
                new BookService(repository);

        Book book = new Book(
                "1ABCD",
                "Clean Code",
                5,
                80,
                "Education"
        );

        boolean result =
                service.addBook(book);

        assertTrue(result);

        assertEquals(1,
                repository.count());
    }

    @Test
    void shouldNotStoreInvalidBook() {

        BookRepository repository =
                new BookRepository();

        BookService service =
                new BookService(repository);

        Book book = new Book(
                "ABCD",
                "Java",
                5,
                2,
                "Kids"
        );

        boolean result =
                service.addBook(book);

        assertFalse(result);

        assertEquals(0,
                repository.count());
    }

    @Test
    void shouldUpdateRepositoryCountCorrectly() {

        BookRepository repository =
                new BookRepository();

        BookService service =
                new BookService(repository);

        Book book1 = new Book(
                "1AAAA",
                "Java Basics",
                10,
                30,
                "Education"
        );

        Book book2 = new Book(
                "2BBBB",
                "Kids Stories",
                8,
                20,
                "Kids"
        );

        service.addBook(book1);
        service.addBook(book2);

        assertEquals(2,
                repository.count());
    }
}
