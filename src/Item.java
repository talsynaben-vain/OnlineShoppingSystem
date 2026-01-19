import java.util.Objects;

public class Item {
    private final long id;
    private String name;
    private double price;

    public Item(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public double finalPrice() {
        return price;
    }

    @Override
    public String toString() {
        return id + " " + name + " : " + price;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Item && id == ((Item) o).id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
