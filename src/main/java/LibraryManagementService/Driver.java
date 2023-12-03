package LibraryManagementService;

import LibraryManagementService.model.Library;
import LibraryManagementService.service.BookCopyService;
import LibraryManagementService.service.BookService;
import LibraryManagementService.service.LibraryService;

public class Driver {

    public static void main(String[] args) {

        // Create Library
        LibraryService libraryService = new LibraryService();
        Library library = libraryService.addLibrary("1", 10);
        System.out.println("Created library with " + library.getRack() + " racks");

        BookService bookService = new BookService(library);
        BookCopyService bookCopyService = new BookCopyService(library);

        // Add Book
        try{
            String rackList = bookService.addBook("1", "book1", "author1,author2", "publisher1",
                    "book_copy1,book_copy2,book_copy3");
            System.out.println("Added Book to racks: " + rackList);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        // Add Book
        try{
            String rackList = bookService.addBook("1", "book1", "author1,author2", "publisher1",
                    "book_copy4,book_copy5,book_copy6");
            System.out.println("Added Book to racks: " + rackList);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        // Remove Book Copy
        bookCopyService.removeBookCopy("book_copy3");
        System.out.println("");

    }


}

