package pl.coderslab;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBookes();
    Optional<Book> getBookById(Long id);
    void add(Book book);
    void delete(Long id);
    void edit(Book book);
}
