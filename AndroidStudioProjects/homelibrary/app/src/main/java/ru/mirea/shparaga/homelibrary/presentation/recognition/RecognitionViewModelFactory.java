package ru.mirea.shparaga.homelibrary.presentation.recognition;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import ru.mirea.shparaga.homelibrary.domain.usecases.recognition.BookRecognitionServiceUseCase;

public class RecognitionViewModelFactory implements ViewModelProvider.Factory {
    private final BookRecognitionServiceUseCase recognitionService;

    public RecognitionViewModelFactory(BookRecognitionServiceUseCase recognitionService) {
        this.recognitionService = recognitionService;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(RecognitionViewModel.class)) {
            return (T) new RecognitionViewModel(recognitionService);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
