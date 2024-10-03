package ru.mirea.shparaga.homelibrary.presentation.bookdetails;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import ru.mirea.shparaga.homelibrary.domain.model.Book;
import ru.mirea.shparaga.homelibrary.domain.usecases.bookdetails.GetBookDetailsUseCase;
import ru.mirea.shparaga.homelibrary.data.repository.BookRepositoryImpl;

public class BookDetailsViewModel extends AndroidViewModel {
    private final GetBookDetailsUseCase getBookDetailsUseCase;

    public BookDetailsViewModel(Application application) {
        super(application);

        BookRepositoryImpl bookRepository = new BookRepositoryImpl(application.getApplicationContext());
        getBookDetailsUseCase = new GetBookDetailsUseCase(bookRepository);
    }

    public LiveData<Book> getBookDetails(int bookId) {
        return getBookDetailsUseCase.execute(bookId);
    }
}
