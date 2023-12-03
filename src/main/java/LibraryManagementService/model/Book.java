package LibraryManagementService.model;

import java.util.ArrayList;
import java.util.List;

public class Book {

    String BookId;
    String title;
    String authors;
    String publishers;
    List<BookCopy> bookCopyList;

    public Book(String bookId, String title, String authors, String publishers) {
        BookId = bookId;
        this.title = title;
        this.authors = authors;
        this.publishers = publishers;
        bookCopyList = new ArrayList<>();
    }

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublishers() {
        return publishers;
    }

    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }

    public List<BookCopy> getBookCopyList() {
        return bookCopyList;
    }

    public void setBookCopyList(List<BookCopy> bookCopyList) {
        this.bookCopyList = bookCopyList;
    }

    public void addBookCopy(BookCopy bookCopy){
        bookCopyList.add(bookCopy);
    }
}
