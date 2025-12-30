public class Item {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }

    @Override
    public String toString() {
        return name + " - " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item i = (Item) o;
        return name.equals(i.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
