package ru.mirea.shparaga.homelibrary.domain.repository;

import ru.mirea.shparaga.homelibrary.domain.model.User;

public interface UserRepository {
    boolean updateUser(User user);
    User getUserInfo();
    void logOut();
}