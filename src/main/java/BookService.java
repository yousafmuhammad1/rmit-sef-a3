public class BookService {

    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public boolean addBook(Book book) {

        // Rule 1:
        // ID must be exactly 5 characters
        // and start with a digit

        if (book.getId() == null ||
                !book.getId().matches("\\d.{4}")) {

            return false;
        }

        // Rule 2:
        // Title must contain between 2 and 4 words

        int wordCount =
                book.getTitle().trim().split("\\s+").length;

        if (wordCount < 2 || wordCount > 4) {
            return false;
        }

        // Rule 3:
        // Price must be > 5 and < 250

        if (book.getPrice() <= 5 ||
                book.getPrice() >= 250) {

            return false;
        }

        // Rule 4:
        // Kids books price <= 40

        if (book.getType().equalsIgnoreCase("Kids")
                && book.getPrice() > 40) {

            return false;
        }

        repository.save(book);

        return true;
    }
}
