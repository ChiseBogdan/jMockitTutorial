package repository;

import domain.Person;

import java.sql.Connection;
import java.util.List;

public class PersonRepository {

    private Connection connection=null;

    public PersonRepository() {
        connection = ConnectionFactory.getInstance();
    }


    public Person findOne(String CNP){
        // TO DO
        return null;
    }

    public List<Person> findAll(){
        // TO DO
        return null;
    }
}
