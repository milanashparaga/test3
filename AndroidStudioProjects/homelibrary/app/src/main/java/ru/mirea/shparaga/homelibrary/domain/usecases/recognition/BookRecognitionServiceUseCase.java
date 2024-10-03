package ru.mirea.shparaga.homelibrary.domain.usecases.recognition;

import ru.mirea.shparaga.homelibrary.domain.model.Text;
import ru.mirea.shparaga.homelibrary.domain.repository.TextRecognitionRepository;

public class BookRecognitionServiceUseCase {
    private final TextRecognitionRepository textRecognitionRepository;

    public BookRecognitionServiceUseCase(TextRecognitionRepository textRecognitionRepository) {
        this.textRecognitionRepository = textRecognitionRepository;
    }

    public Text execute(byte[] imageData) {
        return textRecognitionRepository.recognizeTextFromImage(imageData);
    }
}
