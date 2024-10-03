package ru.mirea.shparaga.homelibrary.domain.repository;

import ru.mirea.shparaga.homelibrary.domain.model.AuthToken;

public interface AuthRepository {
    AuthToken signIn(String phone);
    boolean checkToken(String token);
    void sendVerificationCode(String phone);
}
