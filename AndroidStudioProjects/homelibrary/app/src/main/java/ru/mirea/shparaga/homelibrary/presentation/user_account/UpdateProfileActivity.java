package ru.mirea.shparaga.homelibrary.presentation.user_account;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.shparaga.homelibrary.R;
import ru.mirea.shparaga.homelibrary.data.repository.UserRepositoryImpl;
import ru.mirea.shparaga.homelibrary.domain.model.User;
import ru.mirea.shparaga.homelibrary.domain.repository.UserRepository;
import ru.mirea.shparaga.homelibrary.domain.usecases.user_account.UpdateUserInfoUseCase;

public class UpdateProfileActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);
        Button buttonSaveProfile = findViewById(R.id.buttonSaveProfile);
        Button buttonBackToProfile = findViewById(R.id.buttonBackToProfile);

        UserRepository userRepository = new UserRepositoryImpl(this);

        UpdateUserInfoUseCase updateUserInfoUseCase = new UpdateUserInfoUseCase(userRepository);

        buttonSaveProfile.setOnClickListener(view -> {
            String newName = editTextName.getText().toString();
            String newPhone = editTextPhone.getText().toString();

            if (!newName.isEmpty() && !newPhone.isEmpty()) {
                User updatedUser = new User(newName, newPhone);

                boolean success = updateUserInfoUseCase.execute(updatedUser);

                if (success) {
                    Toast.makeText(UpdateProfileActivity.this, "Профиль обновлен", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(UpdateProfileActivity.this, "Ошибка при обновлении", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(UpdateProfileActivity.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
            }
        });

        buttonBackToProfile.setOnClickListener(view -> finish());
    }
}
