package LibraryManagementService.util;

import LibraryManagementService.model.Library;
import LibraryManagementService.service.RackService;

public class Validator {

    public static boolean validateRackAvailability(Library library, int numBookCopies){
        RackService rackService = new RackService(library);
        return numBookCopies <= rackService.getAvaliableRackCount();
    }

}
