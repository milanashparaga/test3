package ru.mirea.shparaga.homelibrary.domain.usecases.user_account;

import ru.mirea.shparaga.homelibrary.domain.model.User;
import ru.mirea.shparaga.homelibrary.domain.repository.UserRepository;

public class GetUserInfoUseCase {
    private final UserRepository userRepository;

    public GetUserInfoUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute() {
        return userRepository.getUserInfo();
    }
}
