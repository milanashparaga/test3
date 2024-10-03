package ru.mirea.shparaga.httpurlconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import ru.mirea.shparaga.httpurlconnection.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //Прошу не пинать за выбор цветов в xml файле, я художник, я так вижу
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(view -> {
            ConnectivityManager connectivityManager =
                    (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkinfo = null;
            if (connectivityManager != null) {
                networkinfo = connectivityManager.getActiveNetworkInfo();
            }
            if (networkinfo != null && networkinfo.isConnected()) {
                new DownloadPageTask().execute("https://ipinfo.io/json");
            } else {
                Toast.makeText(MainActivity.this, "Отсутствует подключение к интернету", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class DownloadPageTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... urls) {
            try {
                return downloadIpInfo(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            try {
                JSONObject responseJson = new JSONObject(result);

                String ip = responseJson.optString("ip");
                binding.ipTextView.setText("IP: " + ip);

                String city = responseJson.optString("city");
                binding.cityTextView.setText("Город: " + city);

                String region = responseJson.optString("region");
                binding.regionTextView.setText("Регион: " + region);

                String loc = responseJson.getString("loc");
                String[] coordinates = loc.split(",");
                if (coordinates.length == 2) {
                    String latitude = coordinates[0];
                    String longitude = coordinates[1];
                    fetchWeatherData(latitude, longitude);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            super.onPostExecute(result);
        }
    }

    private String downloadIpInfo(String address) throws IOException {
        InputStream inputStream = null;
        String data = "";
        try {
            URL url = new URL(address);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(100000);
            connection.setConnectTimeout(100000);
            connection.setRequestMethod("GET");
            connection.setInstanceFollowRedirects(true);
            connection.setUseCaches(false);
            connection.setDoInput(true);
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                inputStream = connection.getInputStream();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                int read = 0;
                while ((read = inputStream.read()) != -1) {
                    bos.write(read);
                }
                bos.close();
                data = bos.toString();
            } else {
                data = connection.getResponseMessage() + ". Ошибка: " + responseCode;
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return data;
    }

    private void fetchWeatherData(String latitude, String longitude) {
        String weatherUrl = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude + "&current_weather=true";
        new FetchWeatherDataTask().execute(weatherUrl);
    }

    private class FetchWeatherDataTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) { // 200 OK
                    InputStream inputStream = connection.getInputStream();
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    int read;
                    byte[] buffer = new byte[1024];
                    while ((read = inputStream.read(buffer)) != -1) {
                        bos.write(buffer, 0, read);
                    }
                    byte[] data = bos.toByteArray();
                    bos.close();
                    inputStream.close();
                    String result = new String(data);
                    return result;
                } else {
                    String error = "Ошибка: " + connection.getResponseMessage();
                    return error;
                }
            } catch (IOException e) {
                e.printStackTrace();
                String errorMessage = "Ошибка: " + e.getMessage();
                return errorMessage;
            }
        }


        @Override
        protected void onPostExecute(String result) {
            try {
                JSONObject responseJson = new JSONObject(result);
                JSONObject weatherJson = responseJson.optJSONObject("current_weather");

                double temperature = weatherJson.optDouble("temperature");
                binding.temperatureTextView.setText("Температура(в градусах): " + temperature);

                double windSpeed = weatherJson.optDouble("windspeed");
                binding.windSpeedTextView.setText("Скорость ветра(км/час): " + windSpeed);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            super.onPostExecute(result);
        }
    }
}
