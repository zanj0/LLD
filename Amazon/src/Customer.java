public abstract  class Customer {
    private ShoppingCart cart;
    private Order order;
    public ShoppingCart getShoppingCart();
    public boolean addItem(Item item);
    public boolean removeItem(Item item);
}
