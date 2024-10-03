package ru.mirea.shparaga.homelibrary.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.shparaga.homelibrary.R;
import ru.mirea.shparaga.homelibrary.presentation.auth.AuthActivity; // Импортируем AuthActivity
import ru.mirea.shparaga.homelibrary.presentation.bookdetails.BookDetailsActivity;
import ru.mirea.shparaga.homelibrary.presentation.booklist.BookListActivity;
import ru.mirea.shparaga.homelibrary.presentation.favorites.FavoritesActivity;
import ru.mirea.shparaga.homelibrary.presentation.recognition.RecognitionActivity;
import ru.mirea.shparaga.homelibrary.presentation.user_account.UserProfileActivity;
import ru.mirea.shparaga.homelibrary.presentation.weather.WeatherActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button weatherButton = findViewById(R.id.buttonWeather);
        weatherButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
            startActivity(intent);
        });

        Button authButton = findViewById(R.id.buttonAuth);
        authButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AuthActivity.class);
            startActivity(intent);
        });

        Button recognitionButton = findViewById(R.id.buttonRecognition);
        recognitionButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RecognitionActivity.class);
            startActivity(intent);
        });

        Button buttonOpenFavorites = findViewById(R.id.buttonOpenFavorites);
        buttonOpenFavorites.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FavoritesActivity.class);
            startActivity(intent);
        });

        Button buttonOpenUserProfile = findViewById(R.id.buttonOpenUserProfile);
        buttonOpenUserProfile.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, UserProfileActivity.class);
            startActivity(intent);
        });

        Button buttonBookInfo = findViewById(R.id.buttonBookInfo);
        buttonBookInfo.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BookDetailsActivity.class);
            intent.putExtra("BOOK_ID", 1);
            startActivity(intent);
        });

        Button buttonOpenBookList = findViewById(R.id.buttonOpenBookList);
        buttonOpenBookList.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BookListActivity.class);
            startActivity(intent);
        });
    }
}
