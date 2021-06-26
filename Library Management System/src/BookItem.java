public class BookItem extends Book {
    private String barCode;
    private Boolean isReferenceOnly;
    private Date borrowDate;
    private Date dueDate;
    public boolean checkout(String memberId){
        if(this.isReferenceOnly()){
            ShowError("This book is reference only and can't be issued");
            return falae;
        }
        if(!BookLending.lendBook(this.getBarCode(), memberId))  {
            return false;
        }
        return true;
    }
}
