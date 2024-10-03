package ru.mirea.shparaga.homelibrary.domain.model;

public class AuthToken {
    private final String token;

    public AuthToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}