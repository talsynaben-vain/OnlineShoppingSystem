import java.util.ArrayList;

public class Order {
    private Customer customer;
    private ArrayList<Item> items;

    public Order(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void showOrder() {
        System.out.println("Order for " + customer.name);
        for (Item i : items) {
            System.out.println(i);
        }
    }
}