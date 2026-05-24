public class BookRepositoryStub extends BookRepository {

    private int saveCalled = 0;

    @Override
    public void save(Book book) {
        saveCalled++;
    }

    public int getSaveCalled() {
        return saveCalled;
    }
}
