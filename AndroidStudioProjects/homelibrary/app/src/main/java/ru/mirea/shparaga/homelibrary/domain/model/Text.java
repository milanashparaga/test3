package ru.mirea.shparaga.homelibrary.domain.model;

public class Text {
    private String recognizedText;

    public Text(String recognizedText) {
        this.recognizedText = recognizedText;
    }

    public String getRecognizedText() {
        return recognizedText;
    }

    public void setRecognizedText(String recognizedText) {
        this.recognizedText = recognizedText;
    }
}
