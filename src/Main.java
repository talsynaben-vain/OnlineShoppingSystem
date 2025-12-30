import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Customer c = new Customer("Alice");
        Order o = new Order(c);

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Phone", 200000));
        items.add(new Item("Laptop", 400000));
        items.add(new Item("Mouse", 5000));

        for (Item item : items) {
            if (item.getPrice() < 300000) {
                o.addItem(item);
            }
        }

        System.out.print("Enter new item name: ");
        String name = sc.nextLine();
        System.out.print("Enter price: ");
        int price = sc.nextInt();
        o.addItem(new Item(name, price));

        o.showOrder();

        for (int i = 0; i < items.size(); i++) {
            for (int j = i + 1; j < items.size(); j++) {
                if (items.get(i).getPrice() > items.get(j).getPrice()) {
                    Item temp = items.get(i);
                    items.set(i, items.get(j));
                    items.set(j, temp);
                }
            }
        }
    }
}