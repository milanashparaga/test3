package ru.mirea.shparaga.homelibrary.domain.usecases.auth;

import ru.mirea.shparaga.homelibrary.domain.repository.AuthRepository;

public class SendVerificationCodeUseCase {
    private final AuthRepository authRepository;

    public SendVerificationCodeUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void execute(String phone) {
        authRepository.sendVerificationCode(phone);
    }
}