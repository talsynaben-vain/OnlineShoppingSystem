public class Customer extends User {

    public Customer(String name) {
        super(name);
    }

    @Override
    public void showRole() {
        System.out.println("I am a customer");
    }
}
