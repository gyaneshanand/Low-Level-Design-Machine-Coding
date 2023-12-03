package LibraryManagementService.model;

public class BookCopy extends Book {

    String bookCopyId;
    int rackId;

    public BookCopy(Book book, String bookCopyId) {
        super(book.BookId, book.title, book.authors, book.publishers);
        this.bookCopyId = bookCopyId;
    }

    public BookCopy(Book book, String bookCopyId, int rackId) {
        super(book.BookId, book.title, book.authors, book.publishers);
        this.bookCopyId = bookCopyId;
        this.rackId = rackId;
    }

    public String getBookCopyId() {
        return bookCopyId;
    }

    public void setBookCopyId(String bookCopyId) {
        this.bookCopyId = bookCopyId;
    }

    public int getRackId() {
        return rackId;
    }

    public void setRackId(int rackId) {
        this.rackId = rackId;
    }
}
