package com.example.temperatureconverter;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    EditText inputEditText;
    RadioButton celsiusRadioButton;
    RadioButton fahrenheitRadioButton;
    Button convertButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.inputEditText);
        celsiusRadioButton = findViewById(R.id.celsiusRadioButton);
        fahrenheitRadioButton = findViewById(R.id.fahrenheitRadioButton);
        convertButton = findViewById(R.id.convertButton);

        convertButton.setOnClickListener(v -> {
            String input = inputEditText.getText().toString().trim();
            if (!input.isEmpty()) {
                double inputValue = Double.parseDouble(input);
                double result;
                String resultUnit;
                if (celsiusRadioButton.isChecked()) {
                    // Convert Celsius to Fahrenheit
                    result = (inputValue * 9 / 5) + 32;
                    resultUnit = "°F";
                } else {
                    // Convert Fahrenheit to Celsius
                    result = (inputValue - 32) * 5 / 9;
                    resultUnit = "°C";
                }
                @SuppressLint("DefaultLocale") String resultMessage = String.format("%.2f %s", result, resultUnit);
                Toast.makeText(MainActivity.this,resultMessage, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Please enter a value.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}