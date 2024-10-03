package ru.mirea.shparaga.homelibrary.domain.usecases.auth;

import ru.mirea.shparaga.homelibrary.domain.model.AuthToken;
import ru.mirea.shparaga.homelibrary.domain.repository.AuthRepository;

public class SignInViaPhoneUseCase {
    private final AuthRepository authRepository;

    public SignInViaPhoneUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public AuthToken execute(String phone) {
        return authRepository.signIn(phone);
    }
}
