package ru.mirea.shparaga.homelibrary.domain.usecases.bookdetails;

import ru.mirea.shparaga.homelibrary.domain.model.Book;
import ru.mirea.shparaga.homelibrary.domain.repository.BookRepository;

public class AddBookToCardUseCase {
    private final BookRepository bookRepository;

    public AddBookToCardUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public boolean execute(Book book) {
        return bookRepository.addBookToCard(book);
    }
}
