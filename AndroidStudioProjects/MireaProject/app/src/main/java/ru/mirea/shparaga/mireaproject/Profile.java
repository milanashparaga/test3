package ru.mirea.shparaga.mireaproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Profile extends Fragment {

    private EditText namePerson;
    private EditText signZodiac;
    private EditText ascendant;
    private EditText timeOfBirth;
    private final String USER_NAME = "USER_NAME";
    private final String USER_SIGN = "USER_SIGN";
    private final String USER_ASCENDANT = "USER_ASCENDANT";
    private final String USER_TIME = "USER_TIME";

    public static Profile newInstance(String param1, String param2) {
        Profile fragment = new Profile();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(this::saveButton);

        namePerson = view.findViewById(R.id.namePerson);
        signZodiac = view.findViewById(R.id.signZodiac);
        ascendant = view.findViewById(R.id.ascendant);
        timeOfBirth = view.findViewById(R.id.timeOfBirth);

        SharedPreferences sharedPref = getContext().getSharedPreferences("profile", Context.MODE_PRIVATE);
        namePerson.setText(sharedPref.getString(USER_NAME, ""));
        signZodiac.setText(sharedPref.getString(USER_SIGN, ""));
        ascendant.setText(sharedPref.getString(USER_ASCENDANT, ""));
        timeOfBirth.setText(sharedPref.getString(USER_TIME, ""));
    }

    public void saveButton(View view){
        SharedPreferences sharedPref = getContext().getSharedPreferences("profile", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString(USER_NAME, namePerson.getText().toString());
        editor.putString(USER_SIGN, signZodiac.getText().toString());
        editor.putString(USER_ASCENDANT, ascendant.getText().toString());
        editor.putString(USER_TIME, timeOfBirth.getText().toString());
        editor.apply();
    }
}