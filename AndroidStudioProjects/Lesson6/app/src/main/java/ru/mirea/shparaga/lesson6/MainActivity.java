package ru.mirea.shparaga.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText numberGroup;
    private EditText numberInGroup;
    private EditText favouriteMovie;
    private final String  NUMBER_GROUP = "NUMBER_GROUP";
    private final String  NUMBER_IN_GROUP = "NUMBER_IN_GROUP";
    private final String  FAVOURITE_MOVIE = "FAVOURITE_MOVIE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberGroup = findViewById(R.id.numberGroup);
        numberInGroup = findViewById(R.id.numberInGroup);
        favouriteMovie = findViewById(R.id.favoriteMovie);

        SharedPreferences sharedPref = getSharedPreferences("mirea_settings", Context.MODE_PRIVATE);
        numberGroup.setText(sharedPref.getString(NUMBER_GROUP, ""));
        numberInGroup.setText(sharedPref.getString(NUMBER_IN_GROUP, ""));
        favouriteMovie.setText(sharedPref.getString(FAVOURITE_MOVIE, ""));
    }

    public void saveButton(View view){
        SharedPreferences	sharedPref	= getSharedPreferences("mirea_settings",	Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(NUMBER_GROUP, numberGroup.getText().toString());
        editor.putString(NUMBER_IN_GROUP, numberInGroup.getText().toString());
        editor.putString(FAVOURITE_MOVIE, favouriteMovie.getText().toString());
        editor.apply();
    }
}