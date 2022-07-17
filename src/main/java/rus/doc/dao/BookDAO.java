package rus.doc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import rus.doc.models.Book;
import rus.doc.models.Person;

import java.util.List;
import java.util.Optional;

/**
 * Created by Vladislav Domaniewski
 */

@Component
public class BookDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public BookDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Book> index() {
        return null;
    }

    public Book show(int id) {
        return null;
    }

    public void save (Book book) {

    }

    public void update(int id, Book updateBook) {

    }

    // Обьединяем таблицы через JOIN
    public Optional<Person> getBookPeople(int id) {
        return null;
    }
    // Убираем владельца книги
    public void freeBook(int id) {
    }

    public void addPersonInBook(int id, Person person) {
    }

    public void deleteBook(int id) {
    }
}
