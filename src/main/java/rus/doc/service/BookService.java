package rus.doc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rus.doc.models.Book;
import rus.doc.models.Person;
import rus.doc.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Vladislav Domaniewski
 */

@Service
@Transactional(readOnly = true)
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> index(Integer page, Integer booksPerPage) {
        return bookRepository.findAll(PageRequest.of(page, booksPerPage, Sort.by("year"))).getContent();
    }

    @Transactional
    public void save(Book book) {
        bookRepository.save(book);
    }

    public Book show(int id) {
        Optional<Book> bookFound = bookRepository.findById(id);
        return bookFound.orElse(null);
    }

    public Person getBookPeople(int id) {
        return bookRepository.findById(id).map(Book::getOwner).orElse(null);
    }

    @Transactional
    public void update(int id, Book updateBook) {
        Book untilForUpdate = bookRepository.findById(id).get();
        updateBook.setId(id);
        updateBook.setOwner(untilForUpdate.getOwner());
        bookRepository.save(updateBook);
    }

    @Transactional
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public void addPersonInBook(int id, Person person) {
        bookRepository.findById(id).ifPresent(
                book -> {
                    book.setOwner(person);
                }
        );
    }

    @Transactional
    public void freeBook(int id) {
        bookRepository.findById(id).ifPresent(
                book -> {
                    book.setOwner(null);
                }
        );
    }
}
