package LibraryManagementService.repository;

import LibraryManagementService.constant.BorrowingStatus;
import LibraryManagementService.model.Borrowing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BorrowingRepository {

    private static BorrowingRepository borrowingRepository;
    private List<Borrowing> borrowingList;

    private BorrowingRepository(){
        this.borrowingList = new ArrayList<>();
    }

    public BorrowingRepository getBorrowingRepository(){
        if(this.borrowingRepository == null){
            borrowingRepository = new BorrowingRepository();
        }
        return borrowingRepository;
    }

    public void createBorrowing(Borrowing borrowing){
        borrowingList.add(borrowing);
    }

    public void updateBorrowing(String userId, String bookCopyId, BorrowingStatus status){
        for(Borrowing borrowing : borrowingList){
            if(borrowing.getUserId().equals(userId) && borrowing.getBookCopyId().equals(bookCopyId)){
                switch (status){
                    case BORROWD:
                        borrowing.setBorrowingStatus(BorrowingStatus.BORROWD);
                        break;
                    case RETURNED:
                        borrowing.setBorrowingStatus(BorrowingStatus.RETURNED);
                        break;
                    default:
                        borrowing.setBorrowingStatus(BorrowingStatus.BORROWD);
                        break;
                }
                break;
            }
        }
    }
}
