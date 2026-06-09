// 5. Deal with Transaction taking two products commit/rollback, handle exception.
import java.sql.*;
import java.util.Scanner;

class transaction {
    private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=mysql;encrypt=true;trustServerCertificate=true";
    private static final String user = "sa";
    private static final String password = "Admin@1234";

    public static void main(String[] args) throws Exception {

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            Scanner s = new Scanner(System.in);

            System.out.println("Enter new price and product id for first update:");
            int price1 = s.nextInt();
            int prod_id1 = s.nextInt();

            System.out.println("Enter new price and product id for second update:");
            int price2 = s.nextInt();
            int prod_id2 = s.nextInt();

            
            con.setAutoCommit(false);

            try {

                String query = "UPDATE products SET price=? WHERE prod_id=?";

                PreparedStatement pt1 = con.prepareStatement(query);
                pt1.setInt(1, price1);
                pt1.setInt(2, prod_id1);
                pt1.executeUpdate();

                PreparedStatement pt2 = con.prepareStatement(query);
                pt2.setInt(1, price2);
                pt2.setInt(2, prod_id2);
                pt2.executeUpdate();

                con.commit();
                System.out.println("Transaction committed");

                pt1.close();
                pt2.close();

            } catch (Exception e) {

                con.rollback();
                System.out.println("Transaction rolled back");
            }

            s.close();
        }
    }
}