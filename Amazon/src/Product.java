public class Product {
    private String productID;
    private String name;
    private String description;
    private double price;
    private ProductCategory category;
    private int availableItemCount;
    private Accout seller;
    public int getAvailableItemCount();
    public boolean updatePrice(double newPrice);
}
