// 2. Display category description and average price of product.
import java.sql.*;

class product_display {
  private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=mysql;encrypt=true;trustServerCertificate=true";
  private static final String user = "sa";
  private static final String password = "Admin@1234";

  public static void main(String[] args) throws Exception {
    try (Connection con = DriverManager.getConnection(url, user, password)) {
      String query = "select category_desc,AVG(price) as avg_price from products group by category_desc";
      PreparedStatement pt = con.prepareStatement(query);
      ResultSet rs = pt.executeQuery();
      while (rs.next()) {
        String cd = rs.getString(1);
        Double price = rs.getDouble(2);
        System.out.print(cd + " ");
        System.out.println(price);
      }
      System.out.println("showing avg price of products of each category mentioned in the table");
    }

  }
}