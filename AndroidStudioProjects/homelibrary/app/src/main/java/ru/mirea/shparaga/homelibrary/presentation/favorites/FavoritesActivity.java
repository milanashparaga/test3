package ru.mirea.shparaga.homelibrary.presentation.favorites;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import ru.mirea.shparaga.homelibrary.R;
import ru.mirea.shparaga.homelibrary.domain.model.Book;

public class FavoritesActivity extends AppCompatActivity {
    private FavoritesViewModel viewModel;
    private EditText editTextBookTitle;
    private EditText editTextBookAuthor;
    private EditText editTextBookDescription;
    private TextView textViewFavorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        editTextBookTitle = findViewById(R.id.editTextBookTitle);
        editTextBookAuthor = findViewById(R.id.editTextBookAuthor);
        editTextBookDescription = findViewById(R.id.editTextBookDescription);
        textViewFavorites = findViewById(R.id.textViewFavorites);
        Button buttonAddBook = findViewById(R.id.buttonAddBook);
        Button buttonRemoveBook = findViewById(R.id.buttonRemoveBook);
        Button buttonBack = findViewById(R.id.buttonBack);

        viewModel = new ViewModelProvider(this).get(FavoritesViewModel.class);

        buttonAddBook.setOnClickListener(v -> {
            String title = editTextBookTitle.getText().toString();
            String author = editTextBookAuthor.getText().toString();
            String description = editTextBookDescription.getText().toString();

            if (!title.isEmpty() && !author.isEmpty() && !description.isEmpty()) {
                viewModel.addBookToFavorites(new Book(1, title, author, description));
            }
        });

        buttonRemoveBook.setOnClickListener(v -> viewModel.removeBookFromFavorites(1));

        buttonBack.setOnClickListener(v -> finish());

        viewModel.getFavoriteBooks().observe(this, books -> {
            StringBuilder favoriteBooksText = new StringBuilder();
            for (Book book : books) {
                favoriteBooksText.append(book.getTitle()).append(" - ").append(book.getAuthor()).append("\n");
            }
            textViewFavorites.setText(favoriteBooksText.toString());
        });
    }
}
