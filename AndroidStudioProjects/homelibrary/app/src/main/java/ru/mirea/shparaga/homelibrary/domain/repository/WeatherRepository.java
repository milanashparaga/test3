package ru.mirea.shparaga.homelibrary.domain.repository;

import ru.mirea.shparaga.homelibrary.domain.model.Weather;

public interface WeatherRepository {
    Weather getWeatherData();
}
