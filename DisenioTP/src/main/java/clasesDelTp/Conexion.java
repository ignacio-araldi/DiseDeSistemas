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
         System.out.println("Se ha establecido la conexi�n con la base de datos\n");
         Statement statement = conn.createStatement();

         ResultSet rs = statement.executeQuery(queryString);
         System.out.println("ID     Comuna   Zonas                                   Director                      Domicilio                     Telefono    Servicios\n");
         while (rs.next()) {
            System.out.println(rs.getString(1)+"      "+rs.getString(2)+"        "+rs.getString(3)+""+rs.getString(4)+""+rs.getString(5)+""+rs.getString(6));

         }
         System.out.println("\n");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
}
//         String queryString = "select * from sysobjects where type='u'";