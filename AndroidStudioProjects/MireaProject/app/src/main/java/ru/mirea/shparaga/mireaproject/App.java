package ru.mirea.shparaga.mireaproject;

import android.app.Application;

import com.yandex.mapkit.MapKitFactory;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        String MAPKIT_API_KEY = "7c8b7168-3ab3-4cca-8a5d-beb7ea9fec66";
        MapKitFactory.setApiKey(MAPKIT_API_KEY);
    }
}