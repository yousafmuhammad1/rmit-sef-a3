import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private List<Book> books = new ArrayList<>();

    public void save(Book book) {
        books.add(book);
    }

    public int count() {
        return books.size();
    }

    public List<Book> getBooks() {
        return books;
    }
}
