package rus.doc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import rus.doc.models.Book;

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

    public void save (Book book) {
        jdbcTemplate.update("INSERT INTO book(name-book, author, age) VALUES(?, ?, ?)",
                book.getNameBook(),
                book.getAge());
    }
}
