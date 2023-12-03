package LibraryManagementService.repository;

import LibraryManagementService.model.BookCopy;

import java.util.HashMap;
import java.util.Map;

public class BookCopyRepository {

    private Map<String, BookCopy> bookCopyMap;

    private static BookCopyRepository bookCopyRepository;

    private BookCopyRepository() {
        this.bookCopyMap = new HashMap<>();
    }

    public static BookCopyRepository getBookCopyRepository() {
        if(bookCopyRepository==null){
            bookCopyRepository = new BookCopyRepository();
        }
        return bookCopyRepository;
    }

    public BookCopy addBookCopy(BookCopy bookCopy){
        bookCopyMap.putIfAbsent(bookCopy.getBookCopyId(), bookCopy);
        return bookCopy;
    }

    public BookCopy getBookCopy(String id){
        return bookCopyMap.getOrDefault(id, null);
    }

    public BookCopy removeBookCopy(String id){
        if(bookCopyMap.containsKey(id)) {
            return bookCopyMap.remove(id);
        }
        return null;
    }

}
