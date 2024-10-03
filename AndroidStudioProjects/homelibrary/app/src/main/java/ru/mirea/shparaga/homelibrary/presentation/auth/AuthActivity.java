package ru.mirea.shparaga.homelibrary.presentation.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import ru.mirea.shparaga.homelibrary.R;
import ru.mirea.shparaga.homelibrary.data.repository.AuthRepositoryImpl; // Импортируйте ваш репозиторий
import ru.mirea.shparaga.homelibrary.domain.usecases.auth.SendVerificationCodeUseCase;
import ru.mirea.shparaga.homelibrary.presentation.MainActivity;

public class AuthActivity extends AppCompatActivity {
    private AuthViewModel authViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        authViewModel = new AuthViewModel(new AuthRepositoryImpl(), new SendVerificationCodeUseCase(new AuthRepositoryImpl()));

        EditText phoneEditText = findViewById(R.id.phoneEditText);
        Button signInButton = findViewById(R.id.signInButton);
        Button sendCodeButton = findViewById(R.id.sendCodeButton);
        Button backButton = findViewById(R.id.backButton);
        TextView resultTextView = findViewById(R.id.resultTextView);

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(AuthActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        signInButton.setOnClickListener(v -> {
            String phone = phoneEditText.getText().toString().trim();
            if (!phone.isEmpty()) {
                authViewModel.signIn(phone);
                authViewModel.getAuthToken().observe(AuthActivity.this, authToken -> {
                    if (authToken != null) {
                        resultTextView.setText("Вход с токеном: " + authToken.getToken());
                    } else {
                        resultTextView.setText("Ошибка входа.");
                    }
                });
            } else {
                resultTextView.setText("Введите номер телефона для входа.");
            }
        });

        sendCodeButton.setOnClickListener(v -> {
            String phone = phoneEditText.getText().toString().trim();
            if (!phone.isEmpty()) {
                authViewModel.sendVerificationCode(phone);
                resultTextView.setText("Код подтверждения отправлен на " + phone);
            } else {
                resultTextView.setText("Введите номер телефона для отправки кода.");
            }
        });
    }
}
