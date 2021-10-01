package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JpaBookService implements BookService {
    private final EntityManager entityManager;
    private final BookRepository bookRepository;

    public JpaBookService(EntityManager entityManager, BookRepository bookRepository) {
        this.entityManager = entityManager;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBookes() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public void edit(Book book) {
        entityManager.merge(book);
    }
}