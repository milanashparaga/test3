package ru.mirea.shparaga.homelibrary.data.repository;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.mirea.shparaga.homelibrary.domain.model.Book;
import ru.mirea.shparaga.homelibrary.domain.repository.BookRepository;

public class BookRepositoryImpl implements BookRepository {
    private static final String PREFS_NAME = "favorite_books_prefs";
    private final SharedPreferences sharedPreferences;

    private final Map<Integer, Book> cardData = new HashMap<>();

    public BookRepositoryImpl(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public boolean addBookToFavorites(Book book) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(book.getId() + "_title", book.getTitle());
        editor.putString(book.getId() + "_author", book.getAuthor());
        editor.putString(book.getId() + "_description", book.getDescription());
        return editor.commit();
    }

    @Override
    public boolean removeBookFromFavorites(int bookId) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(bookId + "_title");
        editor.remove(bookId + "_author");
        editor.remove(bookId + "_description");
        return editor.commit();
    }

    @Override
    public List<Book> getFavoriteBooks() {
        List<Book> favoriteBooks = new ArrayList<>();
        for (String key : sharedPreferences.getAll().keySet()) {
            if (key.endsWith("_title")) {
                String title = sharedPreferences.getString(key, null);
                int id = Integer.parseInt(key.replace("_title", ""));
                String author = sharedPreferences.getString(id + "_author", null);
                String description = sharedPreferences.getString(id + "_description", null);
                if (title != null) {
                    favoriteBooks.add(new Book(id, title, author, description));
                }
            }
        }
        return favoriteBooks;
    }

    @Override
    public LiveData<Book> getBookDetails(int bookId) {

        if (!cardData.containsKey(bookId)) {
            cardData.put(bookId, new Book(bookId, "Имя:Десять негритят", "Автор:Агата Кристи", "Описание:Всем смотрящим мою работу - удачного вечера!"));
        }

        MutableLiveData<Book> bookData = new MutableLiveData<>();
        Book book = cardData.get(bookId);
        bookData.setValue(book);
        return bookData;
    }

    @Override
    public boolean addBookToCard(Book book) {
        cardData.put(book.getId(), book);
        return true;
    }

    @Override
    public boolean removeBookFromCard(int bookId) {
        return cardData.remove(bookId) != null;
    }

    @Override
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Унесённые ветром", "Маргарет МитчелЛ", "Ретт Батлер - шикарный мужчина!"));
        books.add(new Book(2, "Джейн Эйр", "Шарлотта Бронте", "Мужчина с сумасшедшей женой на чердаке"));
        books.add(new Book(3, "Десять негритят", "Агата Кристи", "Приехали и все умерли"));
        return books;
    }
}
