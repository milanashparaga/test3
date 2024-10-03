package ru.mirea.shparaga.toastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Message(View view) {
        EditText editText = (EditText)findViewById(R.id.editText);
        int len = editText.getText().length();
        Toast toast =Toast.makeText(getApplicationContext(),
                "СТУДЕНТКА №30,ГРУППА БСБО-10-21,Количество символов - " + Integer.toString(len),
                Toast.LENGTH_SHORT);
        toast.show();
    }
}