public class BookReservation {
    private Date creationDate;
    private ReservationStatus status;
    private String bookItemBarCode;
    private String memberId;
    public static BookReservation fetchReservationDetails(String barcode);

}
