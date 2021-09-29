package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    @ResponseBody
    public List<Book> getList() {
        return bookService.getBookes();
    }
    @GetMapping("/{id}")
    @ResponseBody
    public Book getBookById(@PathVariable Long id)
    {
        return bookService.getBookById(id).orElseThrow(()->
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        });
    }
    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        bookService.add(book);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id)
    {
        bookService.delete(id);
    }
}