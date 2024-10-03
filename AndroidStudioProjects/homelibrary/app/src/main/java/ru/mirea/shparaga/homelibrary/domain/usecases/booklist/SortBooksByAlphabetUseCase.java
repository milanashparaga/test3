package ru.mirea.shparaga.homelibrary.domain.usecases.booklist;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import ru.mirea.shparaga.homelibrary.domain.model.Book;
import ru.mirea.shparaga.homelibrary.domain.repository.BookRepository;

public class SortBooksByAlphabetUseCase {
    private final BookRepository bookRepository;

    public SortBooksByAlphabetUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> execute() {
        List<Book> books = bookRepository.getBooks();
        Collections.sort(books, Comparator.comparing(Book::getTitle));
        return books;
    }
}
