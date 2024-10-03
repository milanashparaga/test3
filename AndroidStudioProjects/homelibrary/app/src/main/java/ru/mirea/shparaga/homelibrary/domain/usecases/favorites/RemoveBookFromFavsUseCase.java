package ru.mirea.shparaga.homelibrary.domain.usecases.favorites;

import ru.mirea.shparaga.homelibrary.domain.repository.BookRepository;

public class RemoveBookFromFavsUseCase {
    private final BookRepository bookRepository;

    public RemoveBookFromFavsUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public boolean execute(int bookId) {
        return bookRepository.removeBookFromFavorites(bookId);
    }
}
