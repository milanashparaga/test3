package ru.mirea.shparaga.homelibrary.domain.model;

public class Weather {
    private final double temperature;
    private final int humidity;
    private final String description;

    public Weather(double temperature, int humidity, String description) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.description = description;
    }

    public double getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public String getDescription() {
        return description;
    }
}