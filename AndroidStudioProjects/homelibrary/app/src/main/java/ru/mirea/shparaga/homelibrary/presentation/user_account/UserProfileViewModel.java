package ru.mirea.shparaga.homelibrary.presentation.user_account;

import androidx.lifecycle.ViewModel;

import ru.mirea.shparaga.homelibrary.domain.model.User;
import ru.mirea.shparaga.homelibrary.domain.usecases.user_account.GetUserInfoUseCase;

public class UserProfileViewModel extends ViewModel {
    private final GetUserInfoUseCase getUserInfoUseCase;

    public UserProfileViewModel(GetUserInfoUseCase getUserInfoUseCase) {
        this.getUserInfoUseCase = getUserInfoUseCase;
    }

    public User getUser() {
        return getUserInfoUseCase.execute();
    }
}
