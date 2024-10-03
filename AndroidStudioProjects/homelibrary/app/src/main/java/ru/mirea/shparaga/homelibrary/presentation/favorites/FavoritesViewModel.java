package ru.mirea.shparaga.homelibrary.presentation.favorites;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import ru.mirea.shparaga.homelibrary.data.repository.BookRepositoryImpl;
import ru.mirea.shparaga.homelibrary.domain.model.Book;
import ru.mirea.shparaga.homelibrary.domain.usecases.favorites.AddBookToFavsUseCase;
import ru.mirea.shparaga.homelibrary.domain.usecases.favorites.GetFavsUseCase;
import ru.mirea.shparaga.homelibrary.domain.usecases.favorites.RemoveBookFromFavsUseCase;

public class FavoritesViewModel extends AndroidViewModel {
    private final AddBookToFavsUseCase addBookToFavsUseCase;
    private final GetFavsUseCase getFavsUseCase;
    private final RemoveBookFromFavsUseCase removeBookFromFavsUseCase;
    private final MutableLiveData<List<Book>> favoriteBooksLiveData = new MutableLiveData<>();

    public FavoritesViewModel(@NonNull Application application) {
        super(application);
        BookRepositoryImpl bookRepository = new BookRepositoryImpl(application);
        this.addBookToFavsUseCase = new AddBookToFavsUseCase(bookRepository);
        this.getFavsUseCase = new GetFavsUseCase(bookRepository);
        this.removeBookFromFavsUseCase = new RemoveBookFromFavsUseCase(bookRepository);
        loadFavoriteBooks();
    }

    public LiveData<List<Book>> getFavoriteBooks() {
        return favoriteBooksLiveData;
    }

    public void addBookToFavorites(Book book) {
        addBookToFavsUseCase.execute(book);
        loadFavoriteBooks();
    }

    public void removeBookFromFavorites(int bookId) {
        removeBookFromFavsUseCase.execute(bookId);
        loadFavoriteBooks();
    }

    private void loadFavoriteBooks() {
        favoriteBooksLiveData.setValue(getFavsUseCase.execute());
    }
}
