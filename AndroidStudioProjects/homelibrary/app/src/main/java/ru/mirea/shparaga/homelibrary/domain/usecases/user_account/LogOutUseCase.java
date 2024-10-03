package ru.mirea.shparaga.homelibrary.domain.usecases.user_account;

import ru.mirea.shparaga.homelibrary.domain.repository.UserRepository;

public class LogOutUseCase {
    private final UserRepository userRepository;

    public LogOutUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute() {
        userRepository.logOut();
    }
}
