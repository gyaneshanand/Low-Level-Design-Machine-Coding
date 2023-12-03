package LibraryManagementService.model;

import LibraryManagementService.constant.BorrowingStatus;

import java.util.Date;

public class Borrowing {

    private String borrowingId;
    private String bookCopyId;
    private String userId;
    private Date issueDate;
    private Date dueDate;
    private BorrowingStatus borrowingStatus;

    public Borrowing(String bookCopyId, String userId, Date issueDate, Date dueDate) {
        this.bookCopyId = bookCopyId;
        this.userId = userId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.borrowingStatus = BorrowingStatus.BORROWD;
    }

    public String getBorrowingId() {
        return borrowingId;
    }

    public void setBorrowingId(String borrowingId) {
        this.borrowingId = borrowingId;
    }

    public String getBookCopyId() {
        return bookCopyId;
    }

    public void setBookCopyId(String bookCopyId) {
        this.bookCopyId = bookCopyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public BorrowingStatus getBorrowingStatus() {
        return borrowingStatus;
    }

    public void setBorrowingStatus(BorrowingStatus borrowingStatus) {
        this.borrowingStatus = borrowingStatus;
    }
}
