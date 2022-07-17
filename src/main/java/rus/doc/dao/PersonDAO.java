package rus.doc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rus.doc.models.Book;
import rus.doc.models.Person;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;


/**
 * Created by Vladislav Domaniewski
 */

@Component
public class PersonDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();
        List<Person> people = session.createQuery("select p from Person p", Person.class)
                .getResultList();
        return people;
    }

    public Person show(int id) {
        return null;
    }

    public Optional<Person> show(String name) {
        return null;
    }

    public void save(Person person) {
    }

    public void update(int id, Person updatedPerson) {

    }

    public void delete(int id) {
    }

    public List<Book> getBookId(int id) {
        return null;
    }
}
