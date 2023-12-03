package LibraryManagementService.repository;

import LibraryManagementService.model.Book;

import java.util.HashMap;
import java.util.Map;

public class BookRepository {

    // We can make this Singleton
    BookRepository bookRepository;
    Map<String , Book> bookMap;

    public BookRepository(){
        bookMap = new HashMap<>();
    }

    public Book addBook(Book book){
        if(bookMap.containsKey(book.getBookId())){
            return bookMap.get(book.getBookId());
        }
        bookMap.putIfAbsent(book.getBookId(), book);
        return book;
    }
}
