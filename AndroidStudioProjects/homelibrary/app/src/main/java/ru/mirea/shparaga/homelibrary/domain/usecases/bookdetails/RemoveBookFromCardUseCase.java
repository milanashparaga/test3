package ru.mirea.shparaga.homelibrary.domain.usecases.bookdetails;

import ru.mirea.shparaga.homelibrary.domain.repository.BookRepository;

public class RemoveBookFromCardUseCase {
    private final BookRepository bookRepository;

    public RemoveBookFromCardUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public boolean execute(int bookId) {
        return bookRepository.removeBookFromCard(bookId);
    }
}
