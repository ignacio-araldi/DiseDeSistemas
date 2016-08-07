package clasesDelTp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion
{
   public void dbConnect(String db_connect_string,String queryString)
   {
      try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection conn = DriverManager.getConnection(db_connect_string);
         System.out.println("Se ha establecido la conexión con la base de datos\n");

         System.out.println("\n");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
}