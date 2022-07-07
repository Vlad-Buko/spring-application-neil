package rus.doc.dao;

import org.springframework.stereotype.Component;
import rus.doc.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Vladislav Domaniewski
 */

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "2424";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }



    public List<Person> index() {
        List<Person> people = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM people");

            while (resultSet.next()){
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));

                people.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return people;
    }

    public Person show(int id) {
        return null;
    }

    public void save(Person person) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO people VALUES(" + 1 + ",'" +
                    person.getName() + "'," + person.getAge() + ",'" + person.getEmail() +
                    "')"
            );
        } catch (SQLException e) {
            e.printStackTrace();

        }

//        person.setId(++PEOPLE_COUNT);
//        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
//        Person personToBeUpdated = show(id);
//        personToBeUpdated.setName(updatedPerson.getName());
//        personToBeUpdated.setAge(updatedPerson.getAge());
//        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
//        people.removeIf(p -> p.getId() == id);
    }
}
