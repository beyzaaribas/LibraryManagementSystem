package librarymanagement;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Baglan extends Database {

    public Baglan(){

        String url="jdbc:mysql://" + host + ":" + port + "/" + db_name +"?useUnicode=true&characterEncoding=utf8";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver is not found");
        }

        try {
            con=DriverManager.getConnection(url,username,password);
            System.out.println("Success .");
        } catch (SQLException ex) {
            System.out.println("Error .");
        }
    }
}
