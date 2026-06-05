// 1.Accept prod_id, new name and update the table.
import java.sql.*;
import java.util.Scanner;

class q1 {
  private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=mysql;encrypt=true;trustServerCertificate=true";
  private static final String user = "sa";
  private static final String password = "Admin@1234";

  public static void main(String[] args) throws Exception {
    try (Connection con = DriverManager.getConnection(url, user, password)) {
      Scanner s = new Scanner(System.in);
      int prod_id = s.nextInt();
      String prod_name = s.next();
      String query = "insert into products(prod_id,prod_name) values(?,?)";
      PreparedStatement pt = con.prepareStatement(query);
      pt.setInt(1, prod_id);
      pt.setString(2, prod_name);
      pt.executeUpdate();
      System.out.println("updated the table by inserting new values");
    }

  }
}
