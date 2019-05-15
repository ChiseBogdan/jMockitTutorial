package repository;

import domain.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AccountRepository {

    private Connection connection = null;

    public AccountRepository() {
        connection = ConnectionFactory.getInstance();
    }

    public Account findAccountOfPerson(String CNP, int accountId){
        //TO DO

        return null;
    }

    public List<Account> findAll() {

        //TO DO
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

        return null;
    }

    public Account findOne(int id){
        //TO DO
        return null;
    }
}
