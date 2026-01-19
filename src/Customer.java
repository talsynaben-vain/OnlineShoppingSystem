public class Customer extends User {
    private double balance;

    public Customer(long id, String name, double balance) {
        super(id, name);
        this.balance = balance;
    }

    public boolean pay(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String getRole() {
        return "CUSTOMER";
    }
}
