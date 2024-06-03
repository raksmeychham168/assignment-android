package com.raksmey.assignment_android;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String msg = "Practices : ";
    ImageView image1;
    ImageView image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(msg, "The onCreate() event");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_color));
        }

        image1 = findViewById(R.id.mainHomework1);
        image2 = findViewById(R.id.mainHomework2);

        image1.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, EventHandlerActivity.class);
            startActivity(i);
        });

        image2.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, ExchangeRateActivity.class);
            startActivity(i);
        });

        Button btnRegisterChild = findViewById(R.id.btnRegisterChild);
        Button btnRecordVaccination = findViewById(R.id.btnRecordVaccination);
        Button btnViewRecords = findViewById(R.id.btnViewRecords);
        Button bRecordVaccine = findViewById(R.id.btnRecordVaccine);

        btnRegisterChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterChildActivity.class);
                startActivity(intent);
            }
        });

        btnRecordVaccination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecordVaccinationActivity.class);
                startActivity(intent);
            }
        });

        btnViewRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewRecordsActivity.class);
                startActivity(intent);
            }
        });

        bRecordVaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecordVaccineActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() event");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }
}
