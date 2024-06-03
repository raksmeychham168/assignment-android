package com.raksmey.assignment_android;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


import com.raksmey.assignment_android.models.VaccinationRecord;

import java.util.List;

public class ViewRecordsActivity extends AppCompatActivity {

    private ListView listViewRecords;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_records);

        listViewRecords = findViewById(R.id.listViewRecords);
        db = new DatabaseHelper(this);

        List<VaccinationRecord> records = db.getAllVaccinationRecords();
        VaccinationRecordAdapter adapter = new VaccinationRecordAdapter(this, records);
        listViewRecords.setAdapter(adapter);
    }
}
