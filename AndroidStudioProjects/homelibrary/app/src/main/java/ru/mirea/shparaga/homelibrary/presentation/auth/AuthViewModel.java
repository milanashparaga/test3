package ru.mirea.shparaga.homelibrary.presentation.auth;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ru.mirea.shparaga.homelibrary.data.repository.AuthRepositoryImpl;
import ru.mirea.shparaga.homelibrary.domain.model.AuthToken;
import ru.mirea.shparaga.homelibrary.domain.usecases.auth.CheckTokenUseCase;
import ru.mirea.shparaga.homelibrary.domain.usecases.auth.SendVerificationCodeUseCase;
import ru.mirea.shparaga.homelibrary.domain.usecases.auth.SignInViaPhoneUseCase;

public class AuthViewModel extends ViewModel {
    private final MutableLiveData<AuthToken> authTokenLiveData;
    private final SignInViaPhoneUseCase signInUseCase;
    private final SendVerificationCodeUseCase sendVerificationCodeUseCase;

    public AuthViewModel(AuthRepositoryImpl authRepository, SendVerificationCodeUseCase sendVerificationCodeUseCase) {
        signInUseCase = new SignInViaPhoneUseCase(authRepository);
        CheckTokenUseCase checkTokenUseCase = new CheckTokenUseCase(authRepository);
        this.sendVerificationCodeUseCase = sendVerificationCodeUseCase;
        authTokenLiveData = new MutableLiveData<>();
    }

    public void signIn(String phone) {
        AuthToken token = signInUseCase.execute(phone);
        authTokenLiveData.setValue(token);
    }

    public LiveData<AuthToken> getAuthToken() {
        return authTokenLiveData;
    }

    public void sendVerificationCode(String phone) {
        sendVerificationCodeUseCase.execute(phone);
    }
}
