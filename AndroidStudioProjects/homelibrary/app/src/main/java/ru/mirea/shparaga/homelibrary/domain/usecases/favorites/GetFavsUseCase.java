package ru.mirea.shparaga.homelibrary.domain.usecases.favorites;

import java.util.List;

import ru.mirea.shparaga.homelibrary.domain.model.Book;
import ru.mirea.shparaga.homelibrary.domain.repository.BookRepository;

public class GetFavsUseCase {
    private final BookRepository bookRepository;

    public GetFavsUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> execute() {
        return bookRepository.getFavoriteBooks();
    }
}
