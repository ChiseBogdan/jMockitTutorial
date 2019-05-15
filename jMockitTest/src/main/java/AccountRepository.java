import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountRepository {

    private Connection connection = null;

    public AccountRepository() {
        connection = ConnectionFactory.getInstance();
    }


    public void findOne(int id) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from account");

            while (rs.next()) {
                System.out.println("" + rs.getInt(1) + " " + rs.getDouble(2));
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}
