package ru.mirea.shparaga.homelibrary.domain.usecases.booklist;

import java.util.List;
import java.util.stream.Collectors;
import ru.mirea.shparaga.homelibrary.domain.model.Book;
import ru.mirea.shparaga.homelibrary.domain.repository.BookRepository;

public class GetAuthorBooksUseCase {
    private final BookRepository bookRepository;

    public GetAuthorBooksUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> execute(String author) {
        return bookRepository.getBooks().stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }
}
