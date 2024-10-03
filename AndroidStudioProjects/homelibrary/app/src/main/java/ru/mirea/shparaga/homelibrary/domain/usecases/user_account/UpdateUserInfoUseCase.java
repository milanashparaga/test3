package ru.mirea.shparaga.homelibrary.domain.usecases.user_account;

import ru.mirea.shparaga.homelibrary.domain.model.User;
import ru.mirea.shparaga.homelibrary.domain.repository.UserRepository;

public class UpdateUserInfoUseCase {
    private final UserRepository userRepository;

    public UpdateUserInfoUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean execute(User user) {
        return userRepository.updateUser(user);
    }
}

