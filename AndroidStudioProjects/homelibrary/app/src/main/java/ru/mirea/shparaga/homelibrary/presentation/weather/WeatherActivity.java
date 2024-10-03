package ru.mirea.shparaga.homelibrary.presentation.weather;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.shparaga.homelibrary.R;
import ru.mirea.shparaga.homelibrary.data.repository.WeatherRepositoryImpl;
import ru.mirea.shparaga.homelibrary.domain.usecases.weather.GetWeatherDataUseCase;
import ru.mirea.shparaga.homelibrary.presentation.MainActivity;

public class WeatherActivity extends AppCompatActivity {
    private WeatherViewModel weatherViewModel;
    private TextView temperatureTextView;
    private TextView humidityTextView;
    private TextView descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(WeatherActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        temperatureTextView = findViewById(R.id.textViewTemperature);
        humidityTextView = findViewById(R.id.textViewHumidity);
        descriptionTextView = findViewById(R.id.textViewDescription);
        Button refreshButton = findViewById(R.id.buttonRefresh);

        weatherViewModel = new WeatherViewModel(new GetWeatherDataUseCase(new WeatherRepositoryImpl()));

        weatherViewModel.getWeatherData().observe(this, weather -> {
            temperatureTextView.setText("Temperature: " + weather.getTemperature() + "°C");
            humidityTextView.setText("Humidity: " + weather.getHumidity() + "%");
            descriptionTextView.setText("Description: " + weather.getDescription());
        });

        refreshButton.setOnClickListener(v -> {
            weatherViewModel.loadWeatherData();
        });
    }
}
