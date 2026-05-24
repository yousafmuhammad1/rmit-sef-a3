import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.
import org.junit.jupiter.api.Test;

public class BookServiceUnitTest {

    @Test
    void shouldAddValidBook() {

        BookRepositoryStub stub =
                new BookRepositoryStub();

        BookService service =
                new BookService(stub);

        Book book = new Book(
                "1ABCD",
                "Java Programming",
                10,
                50,
                "Education"
        );

        boolean result = service.addBook(book);

        assertTrue(result);

        assertEquals(1,
                stub.getSaveCalled());
    }

    @Test
    void shouldRejectInvalidId() {

        BookRepositoryStub stub =
                new BookRepositoryStub();

        BookService service =
                new BookService(stub);

        Book book = new Book(
                "ABCDE",
                "Java Programming",
                10,
                50,
                "Education"
        );

        boolean result = service.addBook(book);

        assertFalse(result);

        assertEquals(0,
                stub.getSaveCalled());
    }

    @Test
    void shouldRejectShortTitle() {

        BookRepositoryStub stub =
                new BookRepositoryStub();

        BookService service =
                new BookService(stub);

        Book book = new Book(
                "1ABCD",
                "Java",
                10,
                50,
                "Education"
        );

        boolean result = service.addBook(book);

        assertFalse(result);

        assertEquals(0,
                stub.getSaveCalled());
    }

    @Test
    void shouldRejectLongTitle() {

        BookRepositoryStub stub =
                new BookRepositoryStub();

        BookService service =
                new BookService(stub);

        Book book = new Book(
                "1ABCD",
                "Advanced Java Programming Concepts Guide",
                10,
                50,
                "Education"
        );

        boolean result = service.addBook(book);

        assertFalse(result);

        assertEquals(0,
                stub.getSaveCalled());
    }

    @Test
    void shouldRejectLowPrice() {

        BookRepositoryStub stub =
                new BookRepositoryStub();

        BookService service =
                new BookService(stub);

        Book book = new Book(
                "1ABCD",
                "Java Programming",
                10,
                3,
                "Education"
        );

        boolean result = service.addBook(book);

        assertFalse(result);

        assertEquals(0,
                stub.getSaveCalled());
    }

    @Test
    void shouldRejectExpensiveKidsBook() {

        BookRepositoryStub stub =
                new BookRepositoryStub();

        BookService service =
                new BookService(stub);

        Book book = new Book(
                "1ABCD",
                "Kids Story",
                10,
                45,
                "Kids"
        );

        boolean result = service.addBook(book);

        assertFalse(result);

        assertEquals(0,
                stub.getSaveCalled());
    }
}
