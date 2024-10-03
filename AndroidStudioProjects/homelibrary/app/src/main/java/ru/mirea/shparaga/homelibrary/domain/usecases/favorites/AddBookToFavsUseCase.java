package ru.mirea.shparaga.homelibrary.domain.usecases.favorites;

import ru.mirea.shparaga.homelibrary.domain.model.Book;
import ru.mirea.shparaga.homelibrary.domain.repository.BookRepository;

public class AddBookToFavsUseCase {
    private final BookRepository bookRepository;

    public AddBookToFavsUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public boolean execute(Book book) {
        return bookRepository.addBookToFavorites(book);
    }
}
