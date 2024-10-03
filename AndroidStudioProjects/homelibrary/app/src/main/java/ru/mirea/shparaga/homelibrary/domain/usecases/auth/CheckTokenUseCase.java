package ru.mirea.shparaga.homelibrary.domain.usecases.auth;

import ru.mirea.shparaga.homelibrary.domain.repository.AuthRepository;

public class CheckTokenUseCase {
    private final AuthRepository authRepository;

    public CheckTokenUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public boolean execute(String token) {
        return authRepository.checkToken(token);
    }
}
