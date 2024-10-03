package ru.mirea.shparaga.homelibrary.domain.usecases.booklist;

import java.util.List;
import java.util.stream.Collectors;
import ru.mirea.shparaga.homelibrary.domain.model.Book;
import ru.mirea.shparaga.homelibrary.domain.repository.BookRepository;

public class GetGenreBooksUseCase {
    private final BookRepository bookRepository;

    public GetGenreBooksUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> execute(String genre) {
        return bookRepository.getBooks().stream()
                .filter(book -> book.getDescription().contains(genre))
                .collect(Collectors.toList());
    }
}
