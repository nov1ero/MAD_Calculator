package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText firstNumber, secondNumber;
    Button addButton, calculatePiButton;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);
        addButton = findViewById(R.id.addButton);
        calculatePiButton = findViewById(R.id.calculatePiButton); // Initialize the Pi button
        resultText = findViewById(R.id.resultText);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the numbers from the EditText fields
                String num1Str = firstNumber.getText().toString();
                String num2Str = secondNumber.getText().toString();

                // Check if both fields are not empty
                if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
                    // Parse the input to doubles
                    double num1 = Double.parseDouble(num1Str);
                    double num2 = Double.parseDouble(num2Str);

                    // Perform addition
                    double result = num1 + num2;

                    // Display the result
                    resultText.setText("Result (Addition): " + result);
                } else {
                    // Handle empty input fields
                    resultText.setText("Please enter both numbers.");
                }
            }
        });

        calculatePiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the number of iterations for Pi calculation
                String iterationsStr = firstNumber.getText().toString();

                if (!iterationsStr.isEmpty()) {
                    int iterations = Integer.parseInt(iterationsStr);

                    // Calculate Pi using the same method as before
                    double pi = calculatePi(iterations);

                    // Display the result
                    resultText.setText("Result (Pi): " + pi);
                } else {
                    // Handle empty input field
                    resultText.setText("Please enter the number of iterations.");
                }
            }
        });
    }

    private double calculatePi(int iterations) {
        double pi = 0.0;
        boolean isPositive = true;

        for (int i = 0; i < iterations; i++) {
            double term = 1.0 / (2 * i + 1);

            if (isPositive) {
                pi += term;
            } else {
                pi -= term;
            }

            isPositive = !isPositive;
        }

        pi *= 4.0;

        return pi;
    }
}
