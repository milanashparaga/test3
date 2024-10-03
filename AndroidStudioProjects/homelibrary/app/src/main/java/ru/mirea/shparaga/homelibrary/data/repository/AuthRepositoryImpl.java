package ru.mirea.shparaga.homelibrary.data.repository;

import ru.mirea.shparaga.homelibrary.domain.model.AuthToken;
import ru.mirea.shparaga.homelibrary.domain.repository.AuthRepository;

public class AuthRepositoryImpl implements AuthRepository {
    @Override
    public AuthToken signIn(String phone) {
        return new AuthToken("test_token_12345");
    }

    @Override
    public boolean checkToken(String token) {
        return "тест_токен_12345".equals(token);
    }

    @Override
    public void sendVerificationCode(String phone) {
        System.out.println("Код отправлен на: " + phone);
    }
}