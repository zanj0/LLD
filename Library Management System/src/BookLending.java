public class BookLending {
    public Date creationDate;
    public Date dueDate;
    public Date returnDate;
    private String bookItemBarcode;
    private String memberId;
    public static void lendBook(String barcode, String memberId);
    public static BookLending fetchLendingDetails(String barcode);
}
