package ru.mirea.shparaga.homelibrary.presentation.booklist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.mirea.shparaga.homelibrary.domain.model.Book;
import ru.mirea.shparaga.homelibrary.domain.usecases.booklist.GetBooksUseCase;
import ru.mirea.shparaga.homelibrary.domain.usecases.booklist.SortBooksByAlphabetUseCase;

public class BookListViewModel extends ViewModel {

    private final GetBooksUseCase getBooksUseCase;
    private final SortBooksByAlphabetUseCase sortBooksByAlphabetUseCase;

    private final MutableLiveData<List<Book>> booksLiveData = new MutableLiveData<>();

    public BookListViewModel(GetBooksUseCase getBooksUseCase, SortBooksByAlphabetUseCase sortBooksByAlphabetUseCase) {
        this.getBooksUseCase = getBooksUseCase;
        this.sortBooksByAlphabetUseCase = sortBooksByAlphabetUseCase;
        loadBooks();
    }

    public LiveData<List<Book>> getBooks() {
        return booksLiveData;
    }

    private void loadBooks() {
        List<Book> books = getBooksUseCase.execute();
        booksLiveData.setValue(books);
    }

    public void sortBooksByAlphabet() {
        List<Book> sortedBooks = sortBooksByAlphabetUseCase.execute();
        booksLiveData.setValue(sortedBooks);
    }
}