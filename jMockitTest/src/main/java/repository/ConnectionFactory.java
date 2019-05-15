package repository;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static Connection instance=null;
    private ConnectionFactory(){
    }

    private static Connection getNewConnection(){

        Connection con=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/bank?user=root&password=root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Eroare incarcare driver "+e);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Eroare stabilire conexiune "+e);
        }
        return con;
    }

    public static Connection getInstance() {
        try {
            if (instance==null || instance.isClosed()) {
                instance = getNewConnection();
            }

        } catch (SQLException e) {
            System.out.println("Error DB "+e);
        }
        return instance;
    }

}
