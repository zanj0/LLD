public class Account {
    private String userName;
    private String password;
    private AccountStatus status;
    private Address shippingAddress;

    private List <CreditCard> CreditCards;
    private List <ElectronicBankTransfers> bankAccounts;
    public boolean addProduct(Product product);
    public boolean addProductReview(ProductReview productReview);
    public boolean resetPassword();
}
