package rus.doc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional(readOnly = true)
    public List<Book> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from Book p", Book.class).getResultList();
    }

    @Transactional
    public Book show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, id);
    }

    @Transactional
    public void save (Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.save(book);
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
