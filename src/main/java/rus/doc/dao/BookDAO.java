package rus.doc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import rus.doc.models.Book;
import rus.doc.models.Person;

import java.util.List;

/**
 * Created by Vladislav Domaniewski
 */

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM book",
                new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE id=?",
                        new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public void save (Book book) {
        jdbcTemplate.update("INSERT INTO book(name_book, author, age) VALUES(?, ?, ?)",
                book.getNameBook(),
                book.getAuthor(),
                book.getAge());
    }

    public void update(int id, Book updateBook) {
        jdbcTemplate.update("UPDATE book SET name_book=?, author=?, age=?" +
                        "WHERE id=?", updateBook.getNameBook(), updateBook.getAuthor(),
                updateBook.getAge(), id);
    }

    public void deleteBook(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
    }


}