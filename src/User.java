import java.util.Objects;

public abstract class User {
    private final long id;
    private String name;

    protected User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() { return id; }
    public String getName() { return name; }

    public abstract String getRole();

    @Override
    public String toString() {
        return id + " " + name + " (" + getRole() + ")";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof User && id == ((User) o).id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
