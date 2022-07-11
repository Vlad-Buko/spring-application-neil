package rus.doc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import rus.doc.dao.BookDAO;
import rus.doc.dao.PersonDAO;
import rus.doc.models.Book;
import rus.doc.models.Person;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by Vladislav Domaniewski
 */

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookDAO bookDAO;
    private final PersonDAO personDAO;

    @Autowired
    public BookController(BookDAO bookDAO, PersonDAO personDAO) {
        this.bookDAO = bookDAO;
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String indexBook(Model model) {
        model.addAttribute("books", bookDAO.index());
        return "books/index";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book){
        return "books/new";
    }

    @PostMapping
    public String createBook(@ModelAttribute("book") @Valid Book book,
                           BindingResult bindingResult){
         if (bindingResult.hasErrors())
             return "books/new";

         bookDAO.save(book);
         return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String showBooks(@PathVariable("id") int id, Model model,
                            @ModelAttribute("person") Person person) {
        model.addAttribute("book", bookDAO.show(id));

        Optional<Person> bookPeople = bookDAO.getBookPeople(id);
        if(bookPeople.isPresent()) {
            model.addAttribute("personOwner", bookPeople.get());
        } else {
            model.addAttribute("people", personDAO.index());
        }
        return "books/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {

        model.addAttribute("book", bookDAO.show(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String updateBook(@ModelAttribute("book") @Valid Book book,
                         BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()){
            return "books/edit";
        }
        bookDAO.update(id, book);
        return "redirect:/books";
    }



    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookDAO.deleteBook(id);
        return "redirect:/books";
    }

    @PatchMapping("/{id}/release")
    public String freeBook(@PathVariable("id") int id) {
        bookDAO.freeBook(id);
        return "redirect:/books/" + id;
    }

    @PatchMapping("/{id}/assign")
    public String addedPersonBook(@PathVariable("id") int id,
                                  @ModelAttribute() Person person) {
        bookDAO.addPersonInBook(id, person);
        return "redirect:/books/" + id;
    }

}
