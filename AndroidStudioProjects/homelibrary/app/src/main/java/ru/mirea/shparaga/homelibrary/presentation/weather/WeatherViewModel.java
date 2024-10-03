package ru.mirea.shparaga.homelibrary.presentation.weather;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ru.mirea.shparaga.homelibrary.domain.model.Weather;
import ru.mirea.shparaga.homelibrary.domain.usecases.weather.GetWeatherDataUseCase;

public class WeatherViewModel extends ViewModel {
    private final GetWeatherDataUseCase getWeatherDataUseCase;
    private final MutableLiveData<Weather> weatherData = new MutableLiveData<>();

    public WeatherViewModel(GetWeatherDataUseCase getWeatherDataUseCase) {
        this.getWeatherDataUseCase = getWeatherDataUseCase;
        loadWeatherData();
    }

    void loadWeatherData() {
        Weather data = getWeatherDataUseCase.execute();
        weatherData.setValue(data);
    }

    public LiveData<Weather> getWeatherData() {
        return weatherData;
    }
}
