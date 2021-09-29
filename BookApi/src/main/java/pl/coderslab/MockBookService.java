package pl.coderslab;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MockBookService implements BookService{
    private List<Book> books;
    private static Long nextId = 4L;
    public MockBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        books.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }
    @Override
    public List<Book> getBookes() {
        return books;
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return books.stream()
                .filter(book->book.getId().equals(id))
                .findFirst();
    }

    @Override
    public void add(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    @Override
    public void delete(Long id) {
        for (int i = 0; i < books.size(); i++) {
            if(id.equals(books.get(i).getId()))
            {
                books.remove(i);
                break;
            }
        }
    }

    @Override
    public void edit(Book book) {
        List<Book> books = getBooks();
        for (Book b : books) {
            if (book.getId().equals(b.getId())) {
                b.setIsbn(book.getIsbn());
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
                b.setPublisher(book.getPublisher());

                b.setType(book.getType());
                break;
            }
        }
        setBooks(books);
    }

    public List<Book> getBooks() {
        return books;
    }

    public MockBookService setBooks(List<Book> books) {
        this.books = books;
        return this;
    }
}
