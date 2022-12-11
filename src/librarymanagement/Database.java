package librarymanagement;

import java.sql.*;
import java.sql.Connection;


public class Database {

    public static final String username="root";
    public static final String password="";
    public static final String db_name="librarymanagement";
    public static final String host = "localhost";
    public static final int port =3306;

    public static Connection con;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/librarymanagement", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Statement statement=null;
    public static PreparedStatement preparedStatement;





}
