package ru.mirea.shparaga.homelibrary.domain.usecases.bookdetails;

import androidx.lifecycle.LiveData;

import ru.mirea.shparaga.homelibrary.domain.model.Book;
import ru.mirea.shparaga.homelibrary.domain.repository.BookRepository;

public class GetBookDetailsUseCase {
    private final BookRepository bookRepository;

    public GetBookDetailsUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public LiveData<Book> execute(int bookId) {
        return bookRepository.getBookDetails(bookId);
    }
}
