public class Order {
    private Customer customer;
    private Item item;
    private int quantity;

    public Order(Customer customer, Item item, int quantity) {
        this.customer = customer; this.item = item; this.quantity = quantity;
    }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public int total() { return item.getPrice() * quantity; }
}