// 3. Accept details of new product and insert a row.
import java.sql.*;
import java.util.Scanner;

class q3 {
  private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=mysql;encrypt=true;trustServerCertificate=true";
  private static final String user = "sa";
  private static final String password = "Admin@1234";

  public static void main(String[] args) throws Exception {
    try (Connection con = DriverManager.getConnection(url, user, password)) {
      Scanner s = new Scanner(System.in);
      int prod_id = s.nextInt();
      String prod_name = s.next();
      String category_desc = s.next();
      double price = s.nextDouble();
      int quantity = s.nextInt();
      String sale_date = s.next();
      String query = "insert into products(prod_id,prod_name,category_desc,price,quantity,sale_date) values(?,?,?,?,?,?)";
      PreparedStatement pt = con.prepareStatement(query);
      pt.setInt(1, prod_id);
      pt.setString(2, prod_name);
      pt.setString(3, category_desc);
      pt.setDouble(4, price);
      pt.setInt(5, quantity);
      pt.setString(6, sale_date);
      pt.executeUpdate();
      System.out.println("taking input entire row of products table and inserting");
    }

  }
}
