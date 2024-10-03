package ru.mirea.shparaga.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textView = findViewById(R.id.textView);
        Intent intent = getIntent();
        String dateString = intent.getStringExtra("date");
        LocalDateTime dateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String getString = DateTimeFormatter.ofPattern("HH:mm").format(dateTime);
        textView.setText(String.format(Locale.getDefault(), "КВАДРАТ ЗНАЧЕНИЯ " +
                "МОЕГО НОМЕРА ПО СПИСКУ В ГРУППЕ СОСТАВЛЯЕТ %d, А ТЕКУЩЕЕ ВРЕМЯ - %s",
                (int)Math.pow(30, 2), getString));
    }
}
