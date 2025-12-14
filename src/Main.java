public class Main {
    public static void main(String[] args) {
        Customer c = new Customer("Aruzhan");

        Item a = new Item("Apple", 250);
        Item b = new Item("Milk", 500);

        Order o1 = new Order(c, a, 2);
        Order o2 = new Order(c, b, 1);

        System.out.println(c.getName());
        System.out.println(a.getName() + " " + a.getPrice());
        System.out.println(b.getName() + " " + b.getPrice());

        System.out.println("b more expensive? " + b.moreExpensive(a));

        if (o1.total() > o2.total()) System.out.println("o1 bigger");
        else System.out.println("o2 bigger or equal");
    }
}