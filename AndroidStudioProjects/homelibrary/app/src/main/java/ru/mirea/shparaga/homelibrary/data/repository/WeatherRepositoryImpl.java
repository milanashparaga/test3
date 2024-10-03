package ru.mirea.shparaga.homelibrary.data.repository;

import ru.mirea.shparaga.homelibrary.domain.model.Weather;
import ru.mirea.shparaga.homelibrary.domain.repository.WeatherRepository;

public class WeatherRepositoryImpl implements WeatherRepository {
    @Override
    public Weather getWeatherData() {
        // Возврат тестовых данных о погоде
        return new Weather(22.5, 60, "Sunny");
    }
}
