package ru.mirea.shparaga.lesson9.presentation;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import ru.mirea.shparaga.lesson9.R;
import ru.mirea.shparaga.lesson9.data.repository.MovieRepositoryImpl;
import ru.mirea.shparaga.lesson9.domain.models.Movie;
import ru.mirea.shparaga.lesson9.domain.repository.MovieRepository;
import ru.mirea.shparaga.lesson9.domain.usecases.GetFavoriteFilmUseCase;
import ru.mirea.shparaga.lesson9.domain.usecases.SaveMovieToFavoriteUseCase;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText text = findViewById(R.id.editTextMovie);
        TextView textView = findViewById(R.id.textViewMovie);
        MovieRepository movieRepository = new MovieRepositoryImpl(this);

        findViewById(R.id.buttonSaveMovie).setOnClickListener(view -> {
            String movieName = text.getText().toString();
            if (!movieName.isEmpty()) {
                Boolean result = new SaveMovieToFavoriteUseCase(movieRepository)
                        .execute(new Movie(2, movieName));
                textView.setText(String.format("Save result: %s", result));
            } else {
                textView.setText("Введите название фильма");
            }
        });

        findViewById(R.id.buttonGetMovie).setOnClickListener(view -> {
            Movie movie = new GetFavoriteFilmUseCase(movieRepository).execute();
            if (movie != null) {
                textView.setText(String.format("Избранный фильм: %s", movie.getName()));
            } else {
                textView.setText("Нет избранных фильмов");
            }
        });
    }
}
