package ru.mirea.shparaga.homelibrary.presentation.booklist;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import ru.mirea.shparaga.homelibrary.R;
import ru.mirea.shparaga.homelibrary.domain.model.Book;
import ru.mirea.shparaga.homelibrary.domain.repository.BookRepository;
import ru.mirea.shparaga.homelibrary.data.repository.BookRepositoryImpl;
import ru.mirea.shparaga.homelibrary.domain.usecases.booklist.GetBooksUseCase;
import ru.mirea.shparaga.homelibrary.domain.usecases.booklist.SortBooksByAlphabetUseCase;

public class BookListActivity extends AppCompatActivity {
    private ListView listViewBooks;
    private Button buttonSortAlphabet;
    private BookListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        listViewBooks = findViewById(R.id.listViewBooks);
        buttonSortAlphabet = findViewById(R.id.buttonSortAlphabet);
        Button buttonBack = findViewById(R.id.buttonBack);

        BookRepository bookRepository = new BookRepositoryImpl(this);
        GetBooksUseCase getBooksUseCase = new GetBooksUseCase(bookRepository);
        SortBooksByAlphabetUseCase sortBooksByAlphabetUseCase = new SortBooksByAlphabetUseCase(bookRepository);

        viewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @Override
            public <T extends androidx.lifecycle.ViewModel> T create(Class<T> modelClass) {
                return (T) new BookListViewModel(getBooksUseCase, sortBooksByAlphabetUseCase);
            }
        }).get(BookListViewModel.class);

        viewModel.getBooks().observe(this, this::loadBooks);

        buttonSortAlphabet.setOnClickListener(v -> viewModel.sortBooksByAlphabet());

        buttonBack.setOnClickListener(v -> finish());
    }

    private void loadBooks(List<Book> books) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                books.stream().map(Book::getTitle).toArray(String[]::new));
        listViewBooks.setAdapter(adapter);
    }
}
