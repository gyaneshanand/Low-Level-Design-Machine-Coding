package LibraryManagementService.repository;

import LibraryManagementService.model.Library;

import java.util.*;

public class LibraryRepository {

    Map<String , Library> libraryList;

    private static LibraryRepository libraryRepository;

    private LibraryRepository(){
        libraryList = new HashMap<>();
    }

    public static LibraryRepository getLibraryRepository(){
        if(libraryRepository==null){
            libraryRepository = new LibraryRepository();
        }
        return libraryRepository;
    }

    public Library addNewLibrary(Library library){
        if(library.getLibraryId()==null){
            library.setLibraryId(String.valueOf(new Random()));
        }
        libraryList.putIfAbsent(library.getLibraryId(), library);
        return library;
    }
}
