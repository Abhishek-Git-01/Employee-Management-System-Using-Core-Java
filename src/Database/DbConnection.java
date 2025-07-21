package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    public static final String url = "jdbc:mysql://localhost:3306/barsha";
    public static final String username = "root";
    public static final String password = "root";

  public static Connection getConnection() {
      {
          try {
              Class.forName("com.mysql.cj.jdbc.Driver");
              return DriverManager.getConnection(url,username,password);
          } catch (Exception e) {
              e.printStackTrace();
              System.out.println("Connection error !!!!");
          }
      }
      return null;
  }

}
