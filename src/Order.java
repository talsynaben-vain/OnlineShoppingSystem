import java.util.*;

public class Order {
    private final long id;
    private final Customer customer;
    private final List<Item> items = new ArrayList<>();

    public Order(long id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public double total() {
        return items.stream().mapToDouble(Item::finalPrice).sum();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Item> store = new ArrayList<>();
        store.add(new Item(1, "Phone", 200000));
        store.add(new Item(2, "Laptop", 450000));
        store.add(new Item(3, "Book", 5000));

        Customer c = new Customer(1, "Nurbek", 300000);
        Order order = new Order(1, c);

        store.stream()
                .filter(i -> i.getPrice() < 300000)
                .forEach(System.out::println);

        store.sort(Comparator.comparingDouble(Item::getPrice));

        long id = sc.nextLong();
        for (Item i : store) {
            if (i.getId() == id) order.addItem(i);
        }

        System.out.println(order.total());
        System.out.println(c.pay(order.total()));
    }
}
