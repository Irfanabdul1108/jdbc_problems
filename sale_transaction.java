// 4. Accept the details of a sale transact and insert into same table.
import java.sql.*;
import java.util.Scanner;

class sale_transaction {
    private static final String url =
        "jdbc:sqlserver://localhost\\sqlexpress:1433;databaseName=mysql;encrypt=true;trustServerCertificate=true";
    private static final String user = "sa";
    private static final String password = "Admin@1234";

    public static void main(String[] args) throws Exception {

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            Scanner s = new Scanner(System.in);

            System.out.println("Enter the input values one by one");

            int trans_id = s.nextInt();
            int prod_id = s.nextInt();
            int quantity = s.nextInt();
            double amount = s.nextDouble();

            String query =
                "INSERT INTO Sales(trans_id, prod_id, quantity, amount) VALUES(?, ?, ?, ?)";

            PreparedStatement pt = con.prepareStatement(query);

            pt.setInt(1, trans_id);
            pt.setInt(2, prod_id);
            pt.setInt(3, quantity);
            pt.setDouble(4, amount);

            int n = pt.executeUpdate();

            System.out.println(n + " rows inserted");

            pt.close();
            s.close();
        }
    }
}
