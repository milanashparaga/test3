package ru.mirea.shparaga.mireaproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.mirea.shparaga.mireaproject.databinding.FragmentShopBinding;

public class Shop extends Fragment {
    private FragmentShopBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentShopBinding.inflate(inflater, container, false);

        setButtons();

        return binding.getRoot();
    }

    private void setButtons() {

        binding.buttonStromynka.setOnClickListener(v -> startMapActivity(
                "Мой второй дом №1",
                "Стромынка, 20",
                55.794137,
                37.701500));
        binding.buttonVern.setOnClickListener(v -> startMapActivity(
                "Мой второй дом №2",
                "проспект Вернадского, 78",
                55.670010,
                37.480426));
    }

    private void startMapActivity(String title, String description, double latitude, double longitude) {
        Intent intent = new Intent(getActivity(), ShopActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("description", description);
        intent.putExtra("latitude", latitude);
        intent.putExtra("longitude", longitude);
        startActivity(intent);
    }
}