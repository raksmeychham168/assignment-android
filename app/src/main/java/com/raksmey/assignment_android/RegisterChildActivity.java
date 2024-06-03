package com.raksmey.assignment_android;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.raksmey.assignment_android.database.DatabaseHelper;
import com.raksmey.assignment_android.models.Child;

public class RegisterChildActivity extends AppCompatActivity {

    private EditText etChildName, etBirthDate;
    private Button btnSaveChild;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_child);

        etChildName = findViewById(R.id.etChildName);
        etBirthDate = findViewById(R.id.etBirthday);
        btnSaveChild = findViewById(R.id.btnSaveChild);

        db = new DatabaseHelper(this);

        btnSaveChild.setOnClickListener(v -> {
            String name = etChildName.getText().toString();
            String birthDate = etBirthDate.getText().toString();

            if (!name.isEmpty() && !birthDate.isEmpty()) {
                try {
                    db.addChild(new Child(0, name, birthDate));
                    Toast.makeText(RegisterChildActivity.this, "Child registered", Toast.LENGTH_SHORT).show();
                    finish();
                } catch (Exception e) {
                    Log.e("RegisterChildActivity", "Error adding child", e);
                    Toast.makeText(RegisterChildActivity.this, "Error registering child", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(RegisterChildActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
