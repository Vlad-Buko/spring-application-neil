package rus.doc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rus.doc.dao.BookDAO;
import rus.doc.models.Book;

import javax.validation.Valid;

/**
 * Created by Vladislav Domaniewski
 */

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private final BookDAO bookDAO;

    @Autowired
    public BookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String indexBook(Model model) {
        model.addAttribute("books", bookDAO.index());
        return "book/index";
    }

    @PostMapping
    public String createBook(@ModelAttribute("book") @Valid Book book,
                           BindingResult bindingResult){
         if (bindingResult.hasErrors())
             return "book/new";

         bookDAO.save(book);
         return "redirect:/book";
    }

}
