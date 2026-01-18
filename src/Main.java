import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/online_shopping";
        String user = "postgres";
        String password = "Postgres123";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            Statement st = conn.createStatement();

            st.executeUpdate("INSERT INTO shop_customer (name, email) VALUES ('Ali', 'ali@mail.com')");
            st.executeUpdate("INSERT INTO shop_item (name, price) VALUES ('Laptop', 300000)");

            ResultSet rs1 = st.executeQuery("SELECT * FROM shop_customer ORDER BY id");
            while (rs1.next()) {
                System.out.println("CUSTOMER: " + rs1.getInt("id") + " " + rs1.getString("name") + " " + rs1.getString("email"));
            }

            ResultSet rs2 = st.executeQuery("SELECT * FROM shop_item ORDER BY id");
            while (rs2.next()) {
                System.out.println("ITEM: " + rs2.getInt("id") + " " + rs2.getString("name") + " " + rs2.getBigDecimal("price"));
            }

            st.executeUpdate("UPDATE shop_customer SET name='Ali Updated' WHERE email='ali@mail.com'");
            st.executeUpdate("UPDATE shop_item SET price=350000 WHERE name='Laptop'");

            ResultSet rs3 = st.executeQuery("SELECT * FROM shop_customer ORDER BY id");
            while (rs3.next()) {
                System.out.println("AFTER UPDATE CUSTOMER: " + rs3.getInt("id") + " " + rs3.getString("name") + " " + rs3.getString("email"));
            }

            ResultSet rs4 = st.executeQuery("SELECT * FROM shop_item ORDER BY id");
            while (rs4.next()) {
                System.out.println("AFTER UPDATE ITEM: " + rs4.getInt("id") + " " + rs4.getString("name") + " " + rs4.getBigDecimal("price"));
            }

            st.executeUpdate("DELETE FROM shop_customer WHERE email='ali@mail.com'");
            st.executeUpdate("DELETE FROM shop_item WHERE name='Laptop'");

            ResultSet rs5 = st.executeQuery("SELECT * FROM shop_customer ORDER BY id");
            System.out.println("AFTER DELETE CUSTOMER:");
            while (rs5.next()) {
                System.out.println(rs5.getInt("id") + " " + rs5.getString("name") + " " + rs5.getString("email"));
            }

            ResultSet rs6 = st.executeQuery("SELECT * FROM shop_item ORDER BY id");
            System.out.println("AFTER DELETE ITEM:");
            while (rs6.next()) {
                System.out.println(rs6.getInt("id") + " " + rs6.getString("name") + " " + rs6.getBigDecimal("price"));
            }

            System.out.println("DONE");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}