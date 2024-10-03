package ru.mirea.shparaga.homelibrary.data.repository;

import ru.mirea.shparaga.homelibrary.domain.model.Text;
import ru.mirea.shparaga.homelibrary.domain.repository.TextRecognitionRepository;

public class TextRecognitionRepositoryImpl implements TextRecognitionRepository {
    @Override
    public Text recognizeTextFromImage(byte[] imageData) {
        return new Text("Пример распознанного текста книги");
    }
}
