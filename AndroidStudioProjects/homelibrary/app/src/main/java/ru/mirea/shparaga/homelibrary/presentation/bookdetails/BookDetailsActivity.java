package ru.mirea.shparaga.homelibrary.presentation.bookdetails;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import ru.mirea.shparaga.homelibrary.R;
import ru.mirea.shparaga.homelibrary.domain.model.Book;
import ru.mirea.shparaga.homelibrary.data.repository.BookRepositoryImpl;

public class BookDetailsActivity extends AppCompatActivity {
    private BookDetailsViewModel bookDetailsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        TextView textViewTitle = findViewById(R.id.textViewTitle);
        TextView textViewAuthor = findViewById(R.id.textViewAuthor);
        TextView textViewDescription = findViewById(R.id.textViewDescription);
        Button buttonBack = findViewById(R.id.buttonBack);

        bookDetailsViewModel = new ViewModelProvider(this).get(BookDetailsViewModel.class);

        int bookId = getIntent().getIntExtra("BOOK_ID", 0);

        bookDetailsViewModel.getBookDetails(bookId).observe(this, book -> {
            if (book != null) {
                textViewTitle.setText(book.getTitle());
                textViewAuthor.setText(book.getAuthor());
                textViewDescription.setText(book.getDescription());
            }
        });

        buttonBack.setOnClickListener(v -> {
            finish();
        });
    }
}
