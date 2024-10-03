package ru.mirea.shparaga.homelibrary.domain.repository;

import ru.mirea.shparaga.homelibrary.domain.model.Text;

public interface TextRecognitionRepository {
    Text recognizeTextFromImage(byte[] imageData);
}
