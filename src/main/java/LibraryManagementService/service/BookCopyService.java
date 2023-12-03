package LibraryManagementService.service;

import LibraryManagementService.exception.NotFoundException;
import LibraryManagementService.model.Book;
import LibraryManagementService.model.BookCopy;
import LibraryManagementService.model.Library;
import LibraryManagementService.repository.BookCopyRepository;

public class BookCopyService {

    BookCopyRepository bookCopyRepository;
    RackService rackService;

    public BookCopyService(Library library){
        this.bookCopyRepository = BookCopyRepository.getBookCopyRepository();
        this.rackService = new RackService(library);
    }

    public BookCopy removeBookCopy(String bookCopyId){
        // We can use txn here to ensure atomocity of 3 operations
        BookCopy bookCopy = bookCopyRepository.removeBookCopy(bookCopyId);
        if(bookCopy==null){
            throw new NotFoundException("Invalid Book Copy ID");
        }
        // Empty the Rack
        int rackId = bookCopy.getRackId();
        rackService.emptyRack(rackId);
        // Remove the BookCopy from the list in book
        bookCopy.getBookCopyList().remove(bookCopy);

        return bookCopy;
    }
}
