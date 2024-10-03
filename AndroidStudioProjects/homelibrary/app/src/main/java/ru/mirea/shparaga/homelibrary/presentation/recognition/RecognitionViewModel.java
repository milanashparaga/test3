package ru.mirea.shparaga.homelibrary.presentation.recognition;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ru.mirea.shparaga.homelibrary.domain.model.Text;
import ru.mirea.shparaga.homelibrary.domain.usecases.recognition.BookRecognitionServiceUseCase;

public class RecognitionViewModel extends ViewModel {
    private final BookRecognitionServiceUseCase recognitionService;
    private final MutableLiveData<Text> recognizedTextLiveData = new MutableLiveData<>();

    public RecognitionViewModel(BookRecognitionServiceUseCase recognitionService) {
        this.recognitionService = recognitionService;
    }

    public LiveData<Text> getRecognizedText() {
        return recognizedTextLiveData;
    }

    public void recognizeTextFromImage(byte[] imageData) {
        Text recognizedText = recognitionService.execute(imageData);
        recognizedTextLiveData.setValue(recognizedText);
    }
}
