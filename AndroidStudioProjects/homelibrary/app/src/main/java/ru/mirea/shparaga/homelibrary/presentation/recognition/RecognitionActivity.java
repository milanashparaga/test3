package ru.mirea.shparaga.homelibrary.presentation.recognition;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import ru.mirea.shparaga.homelibrary.R;
import ru.mirea.shparaga.homelibrary.data.repository.TextRecognitionRepositoryImpl;
import ru.mirea.shparaga.homelibrary.domain.usecases.recognition.BookRecognitionServiceUseCase;
import ru.mirea.shparaga.homelibrary.presentation.MainActivity;

public class RecognitionActivity extends AppCompatActivity {
    private RecognitionViewModel recognitionViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recognition);

        TextView recognizedTextView = findViewById(R.id.recognizedTextView);
        Button recognizeButton = findViewById(R.id.recognizeButton);
        ImageView imageView = findViewById(R.id.imageView);
        Button backButton = findViewById(R.id.backButton);

        recognitionViewModel = new ViewModelProvider(this,
                new RecognitionViewModelFactory(new BookRecognitionServiceUseCase(new TextRecognitionRepositoryImpl())))
                .get(RecognitionViewModel.class);

        recognizeButton.setOnClickListener(v -> {
            byte[] imageData = new byte[0];
            recognitionViewModel.recognizeTextFromImage(imageData);
        });

        recognitionViewModel.getRecognizedText().observe(this, text -> {
            if (text != null) {
                recognizedTextView.setText(text.getRecognizedText());
            }
        });

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(RecognitionActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
