package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {

    private final BookService bookService;
    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Book> books = bookService.getBookes();
        model.addAttribute("books", books);
        return "all.jsp";
    }

    @GetMapping("/add")
    public String prepareBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "bookForm.jsp";
    }
    @PostMapping("/add")
    public String saveBook(@Valid Book book, BindingResult result) {
        if(result.hasErrors())
            return "bookForm.jsp";
        bookService.add(book);
        return "redirect:all";
    }
    @GetMapping("/{id}")
    public String showPosts(Model model, @PathVariable Long id) {
        Optional<Book> optionalBook = bookService.getBookById(id);
        if(optionalBook.isEmpty())
            return "redirect:all";
        else {
            Book book = optionalBook.get();
            List<Book> books = new ArrayList<>();
            books.add(book);
            model.addAttribute("books", books);
            return "all.jsp";
        }
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        Optional<Book> optionalBook = bookService.getBookById(id);
        if(optionalBook.isPresent()) {
            Book book = optionalBook.get();
            bookService.delete(book);
        }
        return "redirect:/admin/books/all";
    }
    @GetMapping("/edit/{id}")
    public String prepareToEdit(@PathVariable Long id, Model model)
    {
        Optional<Book> optionalBook = bookService.getBookById(id);
        if(optionalBook.isPresent())
        {
            model.addAttribute("book", bookService.getBookById(id));
            return "/admin/books/edit.jsp";
        }
        return "/edit/" + id;
    }
    @PostMapping("/edit")
    @Transactional
    public String edit(@Valid Book book, BindingResult result)
    {
        if(!result.hasErrors())
        {
            bookService.edit(book);
            return "redirect:/admin/books/all";
        }
        return "/admin/books/edit/"+book.getId();
    }
}
