import java.awt.print.Book;

public class Member extends Account {
    private Date dateOfMembership;
    private int totalBooksCheckout;
    public int getTotalBooksCheckout();
    public boolean reserveBookItem(BookItem bookItem);
    public void incrementTotalBooksCheckedout();
    public boolean checkoutBookItem(BookItem bookItem){
        if(this.getTotalBooksCheckout() >= Constants.MAX_BOOKS_ISSUED_TO_A_USER){
            ShowError("The user has already checked-out maximum number of books.");
            return false;
        }
        BookReservation bookReservation = BookReservation.fetchReesrvationDetails(bookItem.getBarcode());
        if(bookReservation != null && bookReservation.getMemberId() != this.getId()){
            ShowError("This book has been reserved by some other user.");
            return false;
        }else if(bookReservation != null){
            bookReservation.updateStatus(ReservationStatus.COMPLETED);
        }
        if(!bookItem.checkOut(this.getId())){
            return false;
        }
        this.incrementTotalBooksCheckedout();
        return true;
    }
    public void checkForFine(String bookItemBarcode){
        BookLending bookLending = BookLending.fetchLendingDetails(bookItemBarcode);
        Date dueDate = bookLending.getDueDate();
        Date today = new Date();
        // check for fine.
        Fine.collectFine(memberId, diffDays);
    }
    public void returnBookItem(BookItem bookItem){
        this.checkForFine(bookItem.getBarCode());
        BookReservation bookReservation = BookReservation.fetchReesrvationDetails(bookItem.getBarcode());
        if(bookReservation != null){
            bookItem.updateBookItemStatus(BookStatus.RESERVED);
            bookReservation.sendBookAvailableNotification();
        }
        bookItem.updateBookItemStatus(BookStatus.AVAILABLE);
    }
    public boolean renewBookItem(BookItem bookItem){
        this.checkForFine(bookItem.getBarCode());
        BookReservation bookReservation = BookReservation.fetchReesrvationDetails(bookItem.getBarcode());
        if(bookReservation != null && bookReservation.getMemberId() != this.getMemberId()){
            ShowError("Book Reserved By Other Member");
            this.decerementTotalCheckedOutBooks();
            bookItem.updateBookItemState(BookStatus.RESERVED);
            bookReservation.sendBookAvailableNotification();
            return false;
        }else if(bookReservation != null){
            bookReservation.updateStatus(ReservationStatus.COMPLETED);
        }
        BookLending.lendBook(bookItem.getBarCode(), this.getId());
        bookItem.updateDueDate(LocalDate.now().plusDays(Constants.MAX_LENDING_DAYS));
        return true;
    }
}
