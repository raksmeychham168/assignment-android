package com.raksmey.assignment_android;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CurrencyConverterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);

        EditText edtAmount = findViewById(R.id.edtAmount);
        Button btnConvert = findViewById(R.id.btnConvert);
        TextView txtResult = findViewById(R.id.txtResult);

        // Get currency pair from intent
        String fromCurrency = getIntent().getStringExtra("fromCurrency");
        String toCurrency = getIntent().getStringExtra("toCurrency");

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Perform currency conversion logic here
                // This is a simplified example, you would use a real exchange rate API in a real app

                double amount = Double.parseDouble(edtAmount.getText().toString());
                double exchangeRate = getExchangeRate(fromCurrency, toCurrency);

                double result = amount * exchangeRate;

                // Display the result
                txtResult.setText(String.format("%.2f %s = %.2f %s", amount, fromCurrency, result, toCurrency));
            }
        });
    }

    // Placeholder method for getting exchange rate (you would use a real API in a real app)
    private double getExchangeRate(String fromCurrency, String toCurrency) {
        // This is a placeholder; you would replace this with actual exchange rate retrieval logic
        // For simplicity, we assume a fixed exchange rate for this example
        if (fromCurrency.equals("KHR") && toCurrency.equals("USD")) {
            return 0.00025; // Replace with actual exchange rate
        } else if (fromCurrency.equals("USD") && toCurrency.equals("KHR")) {
            return 4000; // Replace with actual exchange rate
        } else if (fromCurrency.equals("KHR") && toCurrency.equals("EUR")) {
            return 0.00022; // Replace with actual exchange rate
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("KHR")) {
            return 4500; // Replace with actual exchange rate
        }

        return 1.0; // Default to 1:1 exchange rate if not found
    }
}
