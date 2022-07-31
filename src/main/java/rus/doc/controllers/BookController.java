package rus.doc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import rus.doc.models.Book;
import rus.doc.models.Person;
import rus.doc.service.BookService;
import rus.doc.service.PeopleService;

import javax.validation.Valid;

/**
 * Created by Vladislav Domaniewski
 */

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final PeopleService peopleService;

    @Autowired
    public BookController(BookService bookService, PeopleService peopleService) {
        this.bookService = bookService;
        this.peopleService = peopleService;
    }


    @GetMapping()
    public String indexBook(Model model,
                            @RequestParam(value = "page", required = false) Integer page,
                            @RequestParam(value = "book_per_page", required = false) Integer booksPerPage) {
        model.addAttribute("books", bookService.index(page, booksPerPage));
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

         bookService.save(book);
         return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String showBooks(@PathVariable("id") int id, Model model,
                            @ModelAttribute("person") Person person) {
        model.addAttribute("book", bookService.show(id));

        Person bookPeople = bookService.getBookPeople(id);
        if(bookPeople != null) {
            model.addAttribute("personOwner", bookPeople);
        } else {
            model.addAttribute("people", peopleService.index());
        }
        return "books/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {

        model.addAttribute("book", bookService.show(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String updateBook(@ModelAttribute("book") @Valid Book book,
                         BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()){
            return "books/edit";
        }
        bookService.update(id, book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @PatchMapping("/{id}/release")
    public String freeBook(@PathVariable("id") int id) {
        bookService.freeBook(id);
        return "redirect:/books/" + id;
    }

    @PatchMapping("/{id}/assign")
    public String addedPersonBook(@PathVariable("id") int id,
                                  @ModelAttribute() Person person) {
        bookService.addPersonInBook(id, person);
        return "redirect:/books/" + id;
    }
}
