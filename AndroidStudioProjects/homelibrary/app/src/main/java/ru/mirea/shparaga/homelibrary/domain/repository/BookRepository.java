package ru.mirea.shparaga.homelibrary.domain.repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import ru.mirea.shparaga.homelibrary.domain.model.Book;

public interface BookRepository {
    boolean addBookToFavorites(Book book);
    boolean removeBookFromFavorites(int bookId);
    List<Book> getFavoriteBooks();

    boolean addBookToCard(Book book);
    boolean removeBookFromCard(int bookId);
    LiveData<Book> getBookDetails(int bookId);

    List<Book> getBooks();
}
