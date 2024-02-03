package com.raksmey.assignment_android;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnKhmerToUSD = findViewById(R.id.btnKhmerToUSD);
        Button btnUSDToKhmer = findViewById(R.id.btnUSDToKhmer);
        Button btnKhmerToEuro = findViewById(R.id.btnKhmerToEuro);
        Button btnEuroToKhmer = findViewById(R.id.btnEuroToKhmer);

        btnKhmerToUSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToCurrencyConverter("KHR", "USD");
            }
        });

        btnUSDToKhmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToCurrencyConverter("USD", "KHR");
            }
        });

        btnKhmerToEuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToCurrencyConverter("KHR", "EUR");
            }
        });

        btnEuroToKhmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToCurrencyConverter("EUR", "KHR");
            }
        });
    }

    private void navigateToCurrencyConverter(String fromCurrency, String toCurrency) {
        Intent intent = new Intent(MainActivity.this, CurrencyConverterActivity.class);
        intent.putExtra("fromCurrency", fromCurrency);
        intent.putExtra("toCurrency", toCurrency);
        startActivity(intent);
    }
}
