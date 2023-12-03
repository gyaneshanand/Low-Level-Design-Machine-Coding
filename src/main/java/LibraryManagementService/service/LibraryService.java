package LibraryManagementService.service;

import LibraryManagementService.model.Library;
import LibraryManagementService.repository.LibraryRepository;


public class LibraryService {

    LibraryRepository libraryRepository;

    public LibraryService(){
        libraryRepository = LibraryRepository.getLibraryRepository();
    }

    public Library addLibrary(String libraryId, int rack){
        Library library = new Library(libraryId, rack);
        // We can add Validation if Library is alrady present
        libraryRepository.addNewLibrary(library);
        return library;
    }
}
