package LibraryManagementService.service;

import LibraryManagementService.exception.RackException;
import LibraryManagementService.model.Book;
import LibraryManagementService.model.BookCopy;
import LibraryManagementService.model.Library;
import LibraryManagementService.repository.BookCopyRepository;
import LibraryManagementService.repository.BookRepository;
import LibraryManagementService.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    BookRepository bookRepository;
    BookCopyRepository bookCopyRepository;
    RackService rackService;
    Library library;

    public BookService(Library library){
        bookRepository = new BookRepository();
        bookCopyRepository = BookCopyRepository.getBookCopyRepository();
        this.rackService = new RackService(library);
        this.library = library;
    }

    public String addBook(String bookId, String title, String authors, String publishers, String bookCopyIds){

        String[] bookCopyIdsList = bookCopyIds.split(",");

        // Call Rack Service to validate Rack
        if(!Validator.validateRackAvailability(library, bookCopyIdsList.length)){
            throw new RackException("Rack not available");
        }

        Book book = bookRepository.addBook(new Book(bookId, title, authors, publishers));
        String rackList = " ";
        List<BookCopy> bookCopyList = new ArrayList<>();
        for(String id : bookCopyIdsList){
            // Assumption -> When we get Next Available rack we use that.
            // Else we can just peek and pop after book copy has been actually stored
            int rackId = rackService.getNextAvailableRack();
            bookCopyList.add(new BookCopy(book, id, rackId));
            rackList+= rackId+",";
        }

        book.setBookCopyList(bookCopyList);
        // Assumption -> There will be unique book_copy_id in input
        bookCopyList.forEach(bookCopy -> bookCopyRepository.addBookCopy(bookCopy));
        return rackList;

        // We can do error handling and release racks if we are not able to fill them successfully
    }

}
