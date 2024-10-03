package ru.mirea.shparaga.homelibrary.domain.usecases.weather;

import ru.mirea.shparaga.homelibrary.domain.model.Weather;
import ru.mirea.shparaga.homelibrary.domain.repository.WeatherRepository;

public class GetWeatherDataUseCase {
    private final WeatherRepository weatherRepository;

    public GetWeatherDataUseCase(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public Weather execute() {
        return weatherRepository.getWeatherData();
    }
}
