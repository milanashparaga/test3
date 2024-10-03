package ru.mirea.shparaga.homelibrary.presentation.user_account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.shparaga.homelibrary.R;
import ru.mirea.shparaga.homelibrary.data.repository.UserRepositoryImpl;
import ru.mirea.shparaga.homelibrary.domain.model.User;
import ru.mirea.shparaga.homelibrary.domain.repository.UserRepository;
import ru.mirea.shparaga.homelibrary.domain.usecases.user_account.GetUserInfoUseCase;

public class UserProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewPhone = findViewById(R.id.textViewPhone);
        Button buttonEditProfile = findViewById(R.id.buttonEditProfile);
        Button buttonBackToHome = findViewById(R.id.buttonBackToHome);

        UserRepository userRepository = new UserRepositoryImpl(this);
        GetUserInfoUseCase getUserInfoUseCase = new GetUserInfoUseCase(userRepository);
        User user = getUserInfoUseCase.execute();

        if (user != null) {
            textViewName.setText(user.getName());
            textViewPhone.setText(user.getPhone());
        } else {
            textViewName.setText("Пользователь не найден");
            textViewPhone.setText("Номер телефона не найден");
        }

        buttonEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfileActivity.this, UpdateProfileActivity.class);
                startActivity(intent);
            }
        });

        buttonBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
