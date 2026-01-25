import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Connection conn = DBConnection.getConnection();
             Scanner sc = new Scanner(System.in)) {

            while (true) {
                System.out.println("\n1 Add customer");
                System.out.println("2 Show customers");
                System.out.println("3 Update customer");
                System.out.println("4 Delete customer");
                System.out.println("0 Exit");
                System.out.print("Choose: ");

                String choice = sc.nextLine();

                if (choice.equals("1")) addCustomer(conn, sc);
                else if (choice.equals("2")) showCustomers(conn);
                else if (choice.equals("3")) updateCustomer(conn, sc);
                else if (choice.equals("4")) deleteCustomer(conn, sc);
                else if (choice.equals("0")) break;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // CREATE
    static void addCustomer(Connection conn, Scanner sc) throws SQLException {

        System.out.print("Full name: ");
        String name = sc.nextLine();

        System.out.print("Phone: ");
        String phone = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Address: ");
        String address = sc.nextLine();

        String sql = """
            INSERT INTO shop_customer(full_name, phone, email, address)
            VALUES (?, ?, ?, ?)
        """;

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, phone);
        ps.setString(3, email);
        ps.setString(4, address);
        ps.executeUpdate();

        System.out.println("Customer added");
    }

    // READ
    static void showCustomers(Connection conn) throws SQLException {

        String sql = "SELECT * FROM shop_customer";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.println(
                    rs.getInt("customer_id") + " | " +
                            rs.getString("full_name") + " | " +
                            rs.getString("phone") + " | " +
                            rs.getString("email") + " | " +
                            rs.getString("address")
            );
        }
    }

    // UPDATE
    static void updateCustomer(Connection conn, Scanner sc) throws SQLException {

        System.out.print("Customer ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("New full name: ");
        String name = sc.nextLine();

        System.out.print("New phone: ");
        String phone = sc.nextLine();

        System.out.print("New email: ");
        String email = sc.nextLine();

        System.out.print("New address: ");
        String address = sc.nextLine();

        String sql = """
            UPDATE shop_customer
            SET full_name=?, phone=?, email=?, address=?
            WHERE customer_id=?
        """;

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, phone);
        ps.setString(3, email);
        ps.setString(4, address);
        ps.setInt(5, id);
        ps.executeUpdate();

        System.out.println("Customer updated");
    }

    // DELETE
    static void deleteCustomer(Connection conn, Scanner sc) throws SQLException {

        System.out.print("Customer ID: ");
        int id = Integer.parseInt(sc.nextLine());

        String sql = "DELETE FROM shop_customer WHERE customer_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println("Customer deleted");
    }
}